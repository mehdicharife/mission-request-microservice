package ma.ensias.missionrequestservice.event;

import java.io.Serializable;

public class MissionRequestApprovedEvent implements Serializable{

    private Long professorId;

    private Long missionId;

    private Long requestId;

    public MissionRequestApprovedEvent() {
    }

    public MissionRequestApprovedEvent(Long missionId, Long requestId) {
        this.missionId = missionId;
        this.requestId = requestId;
    }


    public MissionRequestApprovedEvent(Long professorId, Long missionId, Long requestId) {
        this.professorId = professorId;
        this.missionId = missionId;
        this.requestId = requestId;
    }


    public Long getMissionId() {
        return this.missionId;
    }

    public void setMissionId(Long missionId) {
        this.missionId = missionId;
    }

    public Long getRequestId() {
        return this.requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }


    public Long getProfessorId() {
        return this.professorId;
    }

    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
    }



    @Override
    public String toString() {
        return "{" +
            " missionId='" + getMissionId() + "'" +
            ", requestId='" + getRequestId() + "'" +
            "}";
    }

    
}
