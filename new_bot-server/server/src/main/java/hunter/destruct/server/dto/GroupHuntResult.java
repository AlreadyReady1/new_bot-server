package hunter.destruct.server.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Map;

@Builder
@Jacksonized
@Getter
public class GroupHuntResult {

    private String groupName;
    private String groupId;
    private List<String> destructComments;
    private Map<LocalDate, Stats> dataMap;

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
