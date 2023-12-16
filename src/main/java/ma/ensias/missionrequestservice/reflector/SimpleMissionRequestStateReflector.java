package ma.ensias.missionrequestservice.reflector;


import ma.ensias.missionrequestservice.domain.ApprovedMissionRequestState;
import ma.ensias.missionrequestservice.domain.CancelledMissionRequestState;
import ma.ensias.missionrequestservice.domain.CreatedMissionRequestState;
import ma.ensias.missionrequestservice.domain.RejectedMissionRequestState;



public class SimpleMissionRequestStateReflector extends MissionRequestStateReflector {
    
    @Override
    public  CreatedMissionRequestState getCreatedMissionRequestState() {
        return new CreatedMissionRequestState();
    }


    @Override
    public ApprovedMissionRequestState getApprovedMissionRequestState() {
        return new ApprovedMissionRequestState();
    }


    @Override
    public RejectedMissionRequestState getRejectedMissionRequestState() {
        return new RejectedMissionRequestState();
    }

    
    @Override
    public CancelledMissionRequestState getCancelledMissionRequestState() {
        return new CancelledMissionRequestState();
    }
}
