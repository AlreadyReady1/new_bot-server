package hunter.destruct.server.controller;


import hunter.destruct.server.dto.GroupHuntResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/hunt/group")
public interface GroupResource {

    @GetMapping("{groupId}")
    public ResponseEntity<GroupHuntResult> hunt(@PathVariable("groupId") String groupId);
}
