package ensias.ma.missionrequestservice.domain;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
public class MissionRequest implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    public Long professorId;

    @Embedded
    private MissionDetails missionDetails;

    @ManyToOne
    @JoinColumn(name="mission_request_state_id", referencedColumnName="id")
    private MissionRequestState state = new CreatedMissionRequestState();

    public MissionDetails getMissionDetails() {
        return this.missionDetails;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProfessorId() {
        return this.professorId;
    }

    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
    }

    public MissionRequestState getMissionRequestState() {
        return this.state;
    }

    public void setMisssionDetails(MissionDetails missionDetails) {
        this.missionDetails = missionDetails;
    }

    public void approve() {
        state = state.approve(this);
    }

    public void reject() {
        state = state.reject(this);
    }

    public void cancel() {
        state = state.cancel(this);
    }

    public MissionRequest copy(MissionRequestStateReflector reflector) {
        MissionRequest request = new MissionRequest();
        request.id = this.id;
        request.professorId = this.professorId;
        request.missionDetails = this.missionDetails;
        request.state = reflector.convert(state);
        return request;
    }




}