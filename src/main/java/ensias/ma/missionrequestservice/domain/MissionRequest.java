package ensias.ma.missionrequestservice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class MissionRequest {

    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name="mission_request_state_id", referencedColumnName="id")
    private MissionRequestState state;

    public void approve() {
        state = state.approve(this);
    }

    public void reject() {
        state = state.reject(this);
    }

    public void cancel() {
        state = state.cancel(this);
    }

    public MissionRequest copy(MissionRequestStateVisitor visitor) {
        MissionRequest request = new MissionRequest();
        state.accept(visitor);
        request.state = visitor.state;
        return request;
    }


}