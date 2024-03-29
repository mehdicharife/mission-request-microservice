package ma.ensias.missionrequestservice.domain;

import java.io.Serializable;

import jakarta.persistence.*;
import ma.ensias.missionrequestservice.reflector.MissionRequestStateReflector;
import ma.ensias.missionrequestservice.reflector.SimpleMissionRequestStateReflector;


@Entity
@Table(name = "mission_requests")
public class MissionRequest implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private Long professorId;

    private Long missionId;


    @ManyToOne
    @JoinColumn(name="state_id", referencedColumnName="id")
    private MissionRequestState state = new CreatedMissionRequestState();

    @Transient
    private transient SimpleMissionRequestStateReflector stateReflector = new SimpleMissionRequestStateReflector();


    public MissionRequest() {}

    public MissionRequest(Long id, Long professorId, Long missionId) {
        this.id = id;
        this.professorId = professorId;
        this.missionId = missionId;
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

    public Long getMissionId() {
        return this.missionId;
    }

    public void setMissionId(Long missionId) {
        this.missionId = missionId;
    }

    public MissionRequestState getMissionRequestStateCopy() {
        return stateReflector.convert(state);
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
        request.missionId = this.missionId;
        request.state = reflector.convert(state);
        return request;
    }



    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", professorId='" + getProfessorId() + "'" +
            ", missionId='" + getMissionId() + "'" +
            "}";
    }




}