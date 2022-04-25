package hunter.destruct.client.dto;

import hunter.destruct.client.constansts.Month;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

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
    private Map<Month, Stats> dataMap;

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

