package ensias.ma.missionrequestservice.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("APPROVED")
public class ApprovedMissionRequestState extends MissionRequestState {

    private static ApprovedMissionRequestState instance;

    public static ApprovedMissionRequestState getInstance() {
        if(instance ==  null) {
            instance = new ApprovedMissionRequestState();
        }
        return instance;
    }

    @Override
    public MissionRequestState cancel(MissionRequest missionRequest) {
        return ApprovedMissionRequestState.getInstance();
    }

    @Override
    public MissionRequestState approve(MissionRequest missionRequest) {
        return ApprovedMissionRequestState.getInstance();
    }

    @Override
    public MissionRequestState reject(MissionRequest missionRequest) {
        return ApprovedMissionRequestState.getInstance();
    }

    @Override
    public void accept(MissionRequestStateVisitor visitor) {
        visitor.visitApprovedMissionRequestState(this);
    }
}
