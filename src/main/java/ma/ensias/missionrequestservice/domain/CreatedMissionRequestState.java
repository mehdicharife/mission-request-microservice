package ma.ensias.missionrequestservice.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import ma.ensias.missionrequestservice.visitor.MissionRequestStateVisitor;

@Entity
@DiscriminatorValue("CREATED")
public class CreatedMissionRequestState extends MissionRequestState {
    private static CreatedMissionRequestState instance;

    public static CreatedMissionRequestState getInstance() {
        if(instance == null) {
            instance = new CreatedMissionRequestState();
        }
        return instance;
    }

    @Override
    public MissionRequestState approve(MissionRequest missionRequest) {
        return ApprovedMissionRequestState.getInstance();
    }

    @Override
    public MissionRequestState reject(MissionRequest missionRequest) {
        return new RejectedMissionRequestState();
    }

    @Override
    public MissionRequestState cancel(MissionRequest missionRequest) {
        return CancelledMissionRequestState.getInstance();
    }

    @Override
    public void accept(MissionRequestStateVisitor visitor) {
        visitor.visitCreatedMissionRequestState(this);
    }


}
