package hunter.destruct.client.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Builder
@Jacksonized
@Getter
public class GroupHuntResult {

    private String groupName;
    private String groupId;
    private int[] totalPosts;
    private int[] destructPosts;
    private int postCount;
    private List<String> destructComments;
    private Map<LocalDate, Stats> dataMap;

    // TODO: 24.04.2022 сделать Singltone
    //  (Lazy Initialization)

    private static GroupHuntResult emptyResult;

    public static GroupHuntResult empty() {
        if (emptyResult == null) {
            emptyResult = GroupHuntResult.builder()
                .groupName("")
                .groupId("")
                .totalPosts(new int[0])
                .destructPosts(new int[0])
                .destructComments(Collections.emptyList())
                .dataMap(Collections.emptyMap())

                .build();
        }
        return emptyResult;
    }

    public Stats getStatsByMonth(Month month) {
        return dataMap.entrySet().stream()
                .filter(entry -> entry.getKey().getMonth().equals(month))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(new Stats(0,0,0,0,0));
    }

    @Builder
    @Jacksonized
    @Getter
    public static class Stats {

        private int allComments;
        private int destructComments;
        private int messagesAboutTerrorism;
        private int messagesAboutSeparatism;
        private int messagesAboutDrugs;
    }

}

