package ma.ensias.missionrequestservice.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

import ma.ensias.missionrequestservice.domain.MissionRequest;
import ma.ensias.missionrequestservice.dto.MissionRequestDto;
import ma.ensias.missionrequestservice.event.MissionRequestApprovedEvent;
import ma.ensias.missionrequestservice.mapper.MissionRequestMapper;
import ma.ensias.missionrequestservice.service.MissionRequestService;

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
    public MissionRequestDto addMissionRequest(@RequestBody MissionRequest missionRequest) {
        MissionRequest savedMissionRequest = this.missionRequestService.save(missionRequest);
        return MissionRequestMapper.toDto(savedMissionRequest);
    }


    @PatchMapping ("/mission-requests/{id}/approve")
    public MissionRequestDto approveMissionRequestById(@PathVariable Long id) {
        MissionRequest request = this.missionRequestService.getMissionRequestById(id)
                .orElseThrow(IllegalStateException::new);

        request.approve();
        this.missionRequestService.save(request);

        MissionRequestDto requestDto = MissionRequestMapper.toDto(request);
        MissionRequestApprovedEvent missionRequestApprovedEvent = new MissionRequestApprovedEvent(request.getMissionId(), request.getId());

        this.rabbitTemplate.convertAndSend("mission-request-approved", "", missionRequestApprovedEvent);

        return requestDto;
    }


    @PatchMapping("/mission-requests/{id}/reject")
    public MissionRequestDto rejectMissionRequestById(@PathVariable Long id) {
        MissionRequest request = this.missionRequestService.getMissionRequestById(id)
                .orElseThrow(IllegalStateException::new);

        request.reject();
        this.missionRequestService.save(request);

        return MissionRequestMapper.toDto(request);
    }


    @PatchMapping("/mission-requests/{id}/cancel")
    public MissionRequestDto cancelMissionRequestById(@PathVariable Long id) {
        MissionRequest request = this.missionRequestService.getMissionRequestById(id)
                .orElseThrow(IllegalStateException::new);

        request.cancel();
        this.missionRequestService.save(request);

        return MissionRequestMapper.toDto(request);
    }


}
