package hunter.destruct.server.config;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.UserAuthResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import hunter.destruct.server.bot.VKCommand;

@Configuration
public class MainConfig{

    @Value("${application.bot.oauth.authorizeUri}")
    private String AUTHORIZE_URL;
    @Value("${application.bot.oauth.webhookUri}")
    private String webhookUri;
    @Value("${application.bot.oauth.clientId}")
    private int clientId;
    @Value("${application.bot.oauth.clientSecret}")
    private String clientSecret;
    @Value("${application.bot.oauth.authorizationCode}")
    private String authorizationCode;

    @Value("${application.bot.id}")
    private int botId;
    @Value("${application.bot.token}")
    private String botToken;

//    @Bean
//    public VkApiClient vkApiClient(){
//        TransportClient client = HttpTransportClient.getInstance();
//        return new VkApiClient(client);
//    }
//
//    @Bean
//    public UserActor userActor(){
//        try {
//            UserAuthResponse authResponse = vkApiClient()
//                    .oAuth()
//                    .userAuthorizationCodeFlow(clientId, clientSecret, webhookUri, authorizationCode)
//                    .execute();
//
//            System.out.println(authResponse.getUserId());
//            System.out.println(authResponse.getAccessToken());
//
//            return new UserActor(authResponse.getUserId(), authResponse.getAccessToken());
//        } catch (ClientException | ApiException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    @Bean
//    public GroupActor groupActor(){
//        return new GroupActor(botId, botToken);
//    }
//
//    @Bean
//    public VKCommand vkCommand() {
//        return new VKCommand(userActor(), "info", "info about user");
//    }
}
