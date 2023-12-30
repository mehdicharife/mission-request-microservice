package ma.ensias.missionrequestservice.event;

public class MissionRequestApprovedEvent {
    private Long missionId;

    private Long requestId;

    public MissionRequestApprovedEvent() {
    }

    public MissionRequestApprovedEvent(Long missionId, Long requestId) {
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
    
}
