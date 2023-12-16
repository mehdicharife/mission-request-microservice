package ma.ensias.missionrequestservice.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import ma.ensias.missionrequestservice.visitor.MissionRequestStateVisitor;

@Entity
@DiscriminatorValue("CANCELLED")
public class CancelledMissionRequestState extends MissionRequestState {
    private static CancelledMissionRequestState instance;

    public static CancelledMissionRequestState getInstance() {
        if(instance == null) {
            instance = new CancelledMissionRequestState();
        }
        return instance;
    }

    @Override
    public MissionRequestState approve(MissionRequest missionRequest) {
        return CancelledMissionRequestState.getInstance();
    }

    @Override
    public MissionRequestState reject(MissionRequest missionRequest) {
        return CancelledMissionRequestState.getInstance();
    }

    @Override
    public MissionRequestState cancel(MissionRequest missionRequest) {
        return CancelledMissionRequestState.getInstance();
    }

    @Override
    public void accept(MissionRequestStateVisitor visitor) {
        visitor.visitCancelledMissionRequestState(this);
    }


}
