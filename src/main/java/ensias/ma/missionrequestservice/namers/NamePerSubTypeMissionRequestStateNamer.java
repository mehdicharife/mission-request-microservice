package ensias.ma.missionrequestservice.namers;


import ensias.ma.missionrequestservice.domain.ApprovedMissionRequestState;
import ensias.ma.missionrequestservice.domain.CancelledMissionRequestState;
import ensias.ma.missionrequestservice.domain.CreatedMissionRequestState;
import ensias.ma.missionrequestservice.domain.MissionRequestState;
import ensias.ma.missionrequestservice.domain.MissionRequestStateVisitor;
import ensias.ma.missionrequestservice.domain.RejectedMissionRequestState;


public class NamePerSubTypeMissionRequestStateNamer implements MissionRequestStateNamer, MissionRequestStateVisitor {
    
    private String name;

    public String getName(MissionRequestState missionRequestState) {
        missionRequestState.accept(this);
        return name;
    }

    public void visitCreatedMissionRequestState(CreatedMissionRequestState createdMissionRequestState) {
        name = "CREATED";
    }
    
    public void visitApprovedMissionRequestState(ApprovedMissionRequestState approvedMissionRequestState) {
        name = "APPROVED";
    }

    public void visitCancelledMissionRequestState(CancelledMissionRequestState cancelledMissionRequestState) {
        name = "CANCELLED";
    }

    public void visitRejectedMissionRequestState(RejectedMissionRequestState rejectedMissionRequestState) {
        this.name = "REJECTED";
    }

}
