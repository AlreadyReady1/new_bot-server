package hunter.destruct.server.bot;

import com.vk.api.sdk.client.Lang;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.base.City;
import com.vk.api.sdk.objects.base.Sex;
import com.vk.api.sdk.objects.groups.responses.GetResponse;
import com.vk.api.sdk.objects.messages.Message;
import com.vk.api.sdk.objects.wall.responses.SearchResponse;
import lombok.Data;

import java.util.List;

public class VKCommand {

    private final UserActor user;
    private final String identifier;
    private final String description;
    private final com.vk.api.sdk.objects.users.Fields[] userFields = new com.vk.api.sdk.objects.users.Fields[]{
            com.vk.api.sdk.objects.users.Fields.ABOUT,
            com.vk.api.sdk.objects.users.Fields.SEX,
            com.vk.api.sdk.objects.users.Fields.BDATE,
            com.vk.api.sdk.objects.users.Fields.CITY,
            com.vk.api.sdk.objects.users.Fields.NICKNAME,
            com.vk.api.sdk.objects.users.Fields.COUNTERS,
            com.vk.api.sdk.objects.users.Fields.FOLLOWERS_COUNT
    };

    private final com.vk.api.sdk.objects.groups.Fields[] groupFields = new com.vk.api.sdk.objects.groups.Fields[]{
            com.vk.api.sdk.objects.groups.Fields.COUNTERS,
            com.vk.api.sdk.objects.groups.Fields.DESCRIPTION
    };

    public VKCommand(UserActor user, String identifier, String description) {
        this.user = user;
        this.identifier = identifier;
        this.description = description;
    }

    public String processMessage(Message message, VkApiClient vk, GroupActor actor){
        try {
            String userId = userIdFrom(message);
            System.out.println(userId);
            List<com.vk.api.sdk.objects.users.responses.GetResponse> counters = vk.users()
                    .get(actor)
                    .userIds(userId)
                    .fields(userFields)
                    .lang(Lang.RU)
                    .execute();
            lastMessages(counters.get(0).getId(), vk);

            return countersToString(counters);
        } catch (IllegalArgumentException ex) {
            return ex.getMessage();
        } catch (ClientException | ApiException e) {
            e.printStackTrace();
            return "Что то пошло не так...";
        }
    }

    private String userIdFrom(Message message){
        if (message.getText().startsWith(identifier)){
            return message
                    .getText()
                    .substring(identifier.length())
                    .trim();
        } else {
            return "NOT USER TEXT: " + message
                    .getText();
        }
    }

    private String lastMessages(int userId, VkApiClient vk){
        try {
            GetResponse groups = vk.groups()
                    .get(user)
                    .userId(userId)
                    .fields(groupFields)
                    .lang(Lang.RU)
                    .execute();
            groups.getItems().forEach(System.out::println);
            System.out.println(groups.getCount());
            groups.getItems().forEach(g->{
                try {
                    Thread.sleep(2000);
                    SearchResponse list = vk.wall()
                            .search(user)
                            .ownerId(g)
                            .count(10)
                            .execute();
                    list.getItems().forEach(System.out::println);
                } catch (ApiException | ClientException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        } catch (ApiException | ClientException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String countersToString(List<com.vk.api.sdk.objects.users.responses.GetResponse> counters){
        String firstName = counters.get(0).getFirstName();
        String lastName = counters.get(0).getLastName();
        String otherName = counters.get(0).getNickname();
        Sex sex = counters.get(0).getSex();
        int id = counters.get(0).getId();
        City city = counters.get(0).getCity();
        String cityName = city == null ? "неизвестен" : city.getTitle();
        String bDay = counters.get(0).getBdate();
//        String privateProfile = counters.get(0).getHidden()==0 ? "да" : "нет";
        Integer friendCount = counters.get(0).getCounters().getFriends();
        Integer photoCount = counters.get(0).getCounters().getPhotos();
        Integer followersCount = counters.get(0).getFollowersCount();
        Integer groupCount = counters.get(0).getCounters().getGroups();
        return String.format("Имя: %s,\n" +
                "Фамилия: %s,\n" +
                "Никнейм: %s,\n" +
                "Пол: %s,\n" +
                "ID: %d\n" +
                "Город: %s\n" +
                "Дата рождения: %s\n" +
                "Профиль приватный: %s\n" +
                "Количество друзей: %d\n" +
                "Количество фотографий: %d\n" +
                "Количество подписчиков: %d\n" +
                "Количество групп: %d", firstName,lastName,otherName,sex,id,cityName,bDay,"privateProfile",friendCount,photoCount, followersCount,groupCount);
    }

}
