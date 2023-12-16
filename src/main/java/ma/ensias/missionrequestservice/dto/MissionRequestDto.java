package ma.ensias.missionrequestservice.dto;

import ma.ensias.missionrequestservice.domain.MissionDetails;

public class MissionRequestDto {
    private Long id;

    private Long professorId;

    private MissionDetails missionDetails;

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

    public MissionDetails getMissionDetails() {
        return this.missionDetails;
    }

    public void setMissionDetails(MissionDetails missionDetails) {
        this.missionDetails = missionDetails;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
}
