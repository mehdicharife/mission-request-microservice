package ensias.ma.missionrequestservice.domain;

import org.springframework.stereotype.Component;

@Component
public interface MissionRequestStateFactory {
    CreatedMissionRequestState getCreatedMissionRequestState();
    CancelledMissionRequestState getCancelledMissionRequestState();
    ApprovedMissionRequestState getApprovedMissionRequestState();
    RejectedMissionRequestState getRejectedMissionRequestState();
}
