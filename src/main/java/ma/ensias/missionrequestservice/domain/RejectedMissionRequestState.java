package ma.ensias.missionrequestservice.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import ma.ensias.missionrequestservice.visitor.MissionRequestStateVisitor;

@Entity
@DiscriminatorValue("REJECTED")
public class RejectedMissionRequestState extends MissionRequestState {

    private static RejectedMissionRequestState instance;

    public static RejectedMissionRequestState getInstance() {
        if(instance == null) {
            instance = new RejectedMissionRequestState();
        }
        return instance;
    }
    @Override
    public MissionRequestState approve(MissionRequest missionRequest) {
        return RejectedMissionRequestState.getInstance();
    }

    @Override
    public MissionRequestState cancel(MissionRequest missionRequest) {
        return RejectedMissionRequestState.getInstance();
    }

    @Override
    public MissionRequestState reject(MissionRequest missionRequest) {
        return RejectedMissionRequestState.getInstance();
    }

    @Override
    public void accept(MissionRequestStateVisitor visitor) {
        visitor.visitRejectedMissionRequestState(this);
    }

}
