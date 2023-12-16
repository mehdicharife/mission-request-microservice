package ensias.ma.missionrequestservice.controller;

import ensias.ma.missionrequestservice.domain.MissionRequest;
import ensias.ma.missionrequestservice.dto.MissionRequestDto;
import ensias.ma.missionrequestservice.mapper.MissionRequestMapper;
import ensias.ma.missionrequestservice.services.MissionRequestService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MissionRequestController {

    private final MissionRequestService missionRequestService;
    private RabbitTemplate rabbitTemplate;

    public MissionRequestController(MissionRequestService missionRequestService, RabbitTemplate rabbitTemplate) {
        this.missionRequestService = missionRequestService;
        this.rabbitTemplate = rabbitTemplate;
    }


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

    @PatchMapping ("/mission-requests/{id}/approve")
    public MissionRequestDto approveMissionRequestById(@PathVariable Long id) {
        MissionRequest request = this.missionRequestService.getMissionRequestById(id)
                .orElseThrow(IllegalStateException::new);

        request.approve();
        this.missionRequestService.save(request);

        //this.rabbitTemplate.convertAndSend("mission-request-approved", "", request);

        return MissionRequestMapper.toDto(request);
    }

    @PatchMapping("/mission-requests/{id}/reject")
    public MissionRequestDto rejectMissionRequestById(@PathVariable Long id) {
        MissionRequest request = this.missionRequestService.getMissionRequestById(id)
                .orElseThrow(IllegalStateException::new);

        request.reject();
        this.missionRequestService.save(request);

        return MissionRequestMapper.toDto(request);
    }

    @PutMapping("/mission-requests/{id}/cancel")
    public MissionRequestDto cancelMissionRequestById(@PathVariable Long id) {
        MissionRequest request = this.missionRequestService.getMissionRequestById(id)
                .orElseThrow(IllegalStateException::new);

        request.cancel();
        this.missionRequestService.save(request);

        return MissionRequestMapper.toDto(request);
    }


}
