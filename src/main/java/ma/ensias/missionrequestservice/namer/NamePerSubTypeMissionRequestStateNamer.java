package ma.ensias.missionrequestservice.namer;


import ma.ensias.missionrequestservice.domain.ApprovedMissionRequestState;
import ma.ensias.missionrequestservice.domain.CancelledMissionRequestState;
import ma.ensias.missionrequestservice.domain.CreatedMissionRequestState;
import ma.ensias.missionrequestservice.domain.MissionRequestState;
import ma.ensias.missionrequestservice.domain.RejectedMissionRequestState;
import ma.ensias.missionrequestservice.visitor.MissionRequestStateVisitor;


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
