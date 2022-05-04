package hunter.destruct.server.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.time.Month;
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
