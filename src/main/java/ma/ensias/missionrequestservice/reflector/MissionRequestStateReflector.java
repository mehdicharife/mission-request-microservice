package ma.ensias.missionrequestservice.reflector;

import ma.ensias.missionrequestservice.domain.ApprovedMissionRequestState;
import ma.ensias.missionrequestservice.domain.CancelledMissionRequestState;
import ma.ensias.missionrequestservice.domain.CreatedMissionRequestState;
import ma.ensias.missionrequestservice.domain.MissionRequestState;
import ma.ensias.missionrequestservice.domain.MissionRequestStateConverter;
import ma.ensias.missionrequestservice.domain.RejectedMissionRequestState;
import ma.ensias.missionrequestservice.visitor.MissionRequestStateVisitor;

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
