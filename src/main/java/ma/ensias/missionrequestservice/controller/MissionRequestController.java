package ma.ensias.missionrequestservice.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

import ma.ensias.missionrequestservice.domain.MissionRequest;
import ma.ensias.missionrequestservice.dto.MissionRequestDto;
import ma.ensias.missionrequestservice.event.MissionRequestApprovedEvent;
import ma.ensias.missionrequestservice.mapper.MissionRequestMapper;
import ma.ensias.missionrequestservice.service.MissionRequestService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mission-requests")
public class MissionRequestController {

    private final MissionRequestService missionRequestService;
    private RabbitTemplate rabbitTemplate;

    public MissionRequestController(MissionRequestService missionRequestService, RabbitTemplate rabbitTemplate) {
        this.missionRequestService = missionRequestService;
        this.rabbitTemplate = rabbitTemplate;
    }


    @GetMapping
    public List<MissionRequest> getMissionRequests(@RequestParam(value = "professorId", required = false) Optional<Long> id) {
        if(id.isPresent()) {
            return this.missionRequestService.getMissionRequestsByProfessorId(id.get());
        }
        
        return this.missionRequestService.getMissionRequests();
    }


    @GetMapping("/{id}")
    public MissionRequest getMissionRequestById(@PathVariable Long id) {
        return this.missionRequestService.getMissionRequestById(id)
                .orElseThrow(IllegalStateException::new);
    }


    @PostMapping
    public MissionRequestDto addMissionRequest(@RequestBody MissionRequest missionRequest) {
        MissionRequest savedMissionRequest = this.missionRequestService.save(missionRequest);
        return MissionRequestMapper.toDto(savedMissionRequest);
    }



    @PatchMapping ("/{id}/approve")
    public MissionRequestDto approveMissionRequestById(@PathVariable Long id) {
        MissionRequest request = this.missionRequestService.getMissionRequestById(id)
                .orElseThrow(IllegalStateException::new);

        request.approve();
        this.missionRequestService.save(request);

        MissionRequestDto requestDto = MissionRequestMapper.toDto(request);
        MissionRequestApprovedEvent missionRequestApprovedEvent = new MissionRequestApprovedEvent(request.getMissionId(), request.getId(), request.getProfessorId());

        this.rabbitTemplate.convertAndSend("mission-request-approved", "", missionRequestApprovedEvent);

        return requestDto;
    }


    @PatchMapping("{id}/reject")
    public MissionRequestDto rejectMissionRequestById(@PathVariable Long id) {
        MissionRequest request = this.missionRequestService.getMissionRequestById(id)
                .orElseThrow(IllegalStateException::new);

        request.reject();
        this.missionRequestService.save(request);

        return MissionRequestMapper.toDto(request);
    }


    @PatchMapping("{id}/cancel")
    public MissionRequestDto cancelMissionRequestById(@PathVariable Long id) {
        MissionRequest request = this.missionRequestService.getMissionRequestById(id)
                .orElseThrow(IllegalStateException::new);

        request.cancel();
        this.missionRequestService.save(request);

        return MissionRequestMapper.toDto(request);
    }


}
