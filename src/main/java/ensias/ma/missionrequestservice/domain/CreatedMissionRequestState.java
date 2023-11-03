package ensias.ma.missionrequestservice.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CREATED")
public class CreatedMissionRequestState extends MissionRequestState {
    private static CancelledMissionRequestState instance;

    public static CreatedMissionRequestState getInstance() {
        if(instance == null) {
            instance = new CancelledMissionRequestState();
        }
        return instance;
    }

    @Override
    public MissionRequestState approve(MissionRequest missionRequest) {
        return ApprovedMissionRequestState.getInstance();
    }

    @Override
    public MissionRequestState reject(MissionRequest missionRequest) {
        return  new RejectedMissionRequestState();
    }

    @Override
    public MissionRequestState cancel(MissionRequest missionRequest) {
        return CancelledMissionRequestState.getInstance();
    }

    @Override
    public void accept(MissionRequestStateVisitor visitor) {
        visitor.visitCreatedMissionState(this);
    }
}
