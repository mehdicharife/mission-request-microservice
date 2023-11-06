package ensias.ma.missionrequestservice.domain;


import ensias.ma.missionrequestservice.repositories.MissionRequestStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpringBootMissionRequestStateFactory implements MissionRequestStateFactory {

    @Autowired
    private MissionRequestStateRepository repository;

    private static CreatedMissionRequestState createdMissionRequestState;
    private static CancelledMissionRequestState cancelledMissionRequestState;
    private static RejectedMissionRequestState rejectedMissionRequestState;
    private static ApprovedMissionRequestState approvedMissionRequestState;


    public CreatedMissionRequestState getCreatedMissionRequestState() {
        if(createdMissionRequestState == null) {
            createdMissionRequestState = this.repository.getCreatedMissionRequestState();
            if(createdMissionRequestState == null) {
                createdMissionRequestState = new CreatedMissionRequestState();
                // check if it is saved
                this.repository.save(createdMissionRequestState);
            }
        }
        return createdMissionRequestState;
    }


    public ApprovedMissionRequestState getApprovedMissionRequestState() {
        if(approvedMissionRequestState == null) {
            approvedMissionRequestState = this.repository.getApprovedMissionRequestState();
            if(approvedMissionRequestState == null) {
                approvedMissionRequestState = new ApprovedMissionRequestState();
                this.repository.save(approvedMissionRequestState);
            }
        }
        return approvedMissionRequestState;
    }


    public RejectedMissionRequestState getRejectedMissionRequestState() {
        if(rejectedMissionRequestState == null) {
            rejectedMissionRequestState = this.repository.getRejectedMissionRequestState();
            if(rejectedMissionRequestState == null) {
                rejectedMissionRequestState = new RejectedMissionRequestState();
                this.repository.save(rejectedMissionRequestState);
            }
        }
        return rejectedMissionRequestState;
    }


    public CancelledMissionRequestState getCancelledMissionRequestState() {
        if(cancelledMissionRequestState == null) {
            cancelledMissionRequestState = this.repository.getCancelledMissionRequestState();
            if(cancelledMissionRequestState == null) {
                cancelledMissionRequestState = new CancelledMissionRequestState();
                this.repository.save(cancelledMissionRequestState);
            }
        }
        return cancelledMissionRequestState;
    }

    @Override
    public MissionRequestState getState() {
        return null;
    }

}
