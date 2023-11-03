package ensias.ma.missionrequestservice.domain;

public interface MissionRequestStateVisitor {
    void visitCreatedMissionState(CreatedMissionRequestState state);
    void visitApprovedMissionState(ApprovedMissionRequestState state);
    void visitRejectedMissionState(RejectedMissionRequestState state);
    void visitCancelledMissionState(CancelledMissionRequestState state);
}
