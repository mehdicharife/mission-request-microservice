package ensias.ma.missionrequestservice.domain;

public abstract class MissionRequestStateReflector implements MissionRequestStateConverter, MissionRequestStateVisitor {

    private  MissionRequestState outState;
    @Override
    public MissionRequestState convert(MissionRequestState state) {
        state.accept(this);
        return outState;
    }

    @Override
    public void visitCreatedMissionRequestState(CreatedMissionRequestState state) {
        outState = getCreatedMissionRequestState();
    }

    @Override
    public void visitApprovedMissionRequestState(ApprovedMissionRequestState state) {
        outState = getApprovedMissionRequestState();
    }

    @Override
    public void visitRejectedMissionRequestState(RejectedMissionRequestState state) {
        outState = getRejectedMissionRequestState();
    }

    @Override
    public void visitCancelledMissionRequestState(CancelledMissionRequestState state) {
        outState = getCancelledMissionRequestState();
    }

    public abstract CreatedMissionRequestState getCreatedMissionRequestState();
    public abstract ApprovedMissionRequestState getApprovedMissionRequestState();
    public abstract RejectedMissionRequestState getRejectedMissionRequestState();
    public abstract CancelledMissionRequestState getCancelledMissionRequestState();
}
