package ma.ensias.missionrequestservice.visitor;

import ma.ensias.missionrequestservice.domain.ApprovedMissionRequestState;
import ma.ensias.missionrequestservice.domain.CancelledMissionRequestState;
import ma.ensias.missionrequestservice.domain.CreatedMissionRequestState;
import ma.ensias.missionrequestservice.domain.RejectedMissionRequestState;

public interface MissionRequestStateVisitor {
    void visitCreatedMissionRequestState(CreatedMissionRequestState state);
    void visitApprovedMissionRequestState(ApprovedMissionRequestState state);
    void visitRejectedMissionRequestState(RejectedMissionRequestState state);
    void visitCancelledMissionRequestState(CancelledMissionRequestState state);
}
