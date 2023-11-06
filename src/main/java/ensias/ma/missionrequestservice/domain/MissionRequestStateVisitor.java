package ensias.ma.missionrequestservice.domain;

public interface MissionRequestStateVisitor {
    void visitCreatedMissionRequestState(CreatedMissionRequestState state);
    void visitApprovedMissionRequestState(ApprovedMissionRequestState state);
    void visitRejectedMissionRequestState(RejectedMissionRequestState state);
    void visitCancelledMissionRequestState(CancelledMissionRequestState state);
}
