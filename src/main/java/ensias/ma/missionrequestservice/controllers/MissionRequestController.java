package ensias.ma.missionrequestservice.controllers;

import ensias.ma.missionrequestservice.domain.MissionRequest;
import ensias.ma.missionrequestservice.services.MissionRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/mission-requests/")
    public MissionRequest addMissionRequest(@RequestBody MissionRequest missionRequest) {
        return this.missionRequestService.save(missionRequest);
    }

    @PutMapping ("/mission-requests/{id}/approve")
    public MissionRequest approveMissionRequestById(@PathVariable Long id) {
        MissionRequest request = this.missionRequestService.getMissionRequestById(id)
                .orElseThrow(IllegalStateException::new);

        request.approve();
        this.missionRequestService.save(request);

        return request;
    }

    @PutMapping("/mission-requests/{id}/reject")
    public MissionRequest rejectMissionRequestById(@PathVariable Long id) {
        MissionRequest request = this.missionRequestService.getMissionRequestById(id)
                .orElseThrow(IllegalStateException::new);

        request.reject();
        this.missionRequestService.save(request);

        return request;
    }

    @PutMapping("/mission-requests/{id}/cancel")
    public MissionRequest cancelMissionRequestById(@PathVariable Long id) {
        MissionRequest request = this.missionRequestService.getMissionRequestById(id)
                .orElseThrow(IllegalStateException::new);

        request.cancel();
        this.missionRequestService.save(request);

        return request;
    }


}
