package hunter.destruct.client.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

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


}
