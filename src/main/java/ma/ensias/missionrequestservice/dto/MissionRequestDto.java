package ma.ensias.missionrequestservice.dto;


public class MissionRequestDto {
    private Long id;

    private Long professorId;

    private Long missionId;

    private String state;

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

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }
    

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", professorId='" + getProfessorId() + "'" +
            ", missionId='" + getMissionId() + "'" +
            ", state='" + getState() + "'" +
            "}";
    }


}
