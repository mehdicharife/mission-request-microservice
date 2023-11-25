package ensias.ma.missionrequestservice.controllers;

import ensias.ma.missionrequestservice.domain.MissionRequest;
import ensias.ma.missionrequestservice.services.MissionRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MissionRequestController {
    @Autowired
    private MissionRequestService missionRequestService;

    @GetMapping("/mission-requests/")
    public List<MissionRequest> getMissionRequests() {
        return this.missionRequestService.getMissionRequests();
    }

    @GetMapping("/mission-requests/{id}")
    public MissionRequest getMissionRequestById(@PathVariable Long id) {
        return this.missionRequestService.getMissionRequestById(id)
                .orElseThrow(IllegalStateException::new);
    }

    @PostMapping("/mission-requests/{id}/approve")
    public MissionRequest approveMissionRequestById(@PathVariable Long id) {
        MissionRequest request = this.missionRequestService.getMissionRequestById(id)
                .orElseThrow(IllegalStateException::new);

        request.approve();

        return request;
    }

    @PostMapping("/mission-requests/{id}/reject")
    public MissionRequest rejectMissionRequestById(@PathVariable Long id) {
        MissionRequest request = this.missionRequestService.getMissionRequestById(id)
                .orElseThrow(IllegalStateException::new);

        request.reject();

        return request;
    }

    @PostMapping("/mission-requests/{id}/cancel")
    public MissionRequest cancelMissionRequestById(@PathVariable Long id) {
        MissionRequest request = this.missionRequestService.getMissionRequestById(id)
                .orElseThrow(IllegalStateException::new);

        request.cancel();

        return request;
    }


}
