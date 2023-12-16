package ma.ensias.missionrequestservice.reflector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.ensias.missionrequestservice.domain.*;
import ma.ensias.missionrequestservice.repository.MissionRequestStateRepository;


@Component
public final class MissionRequestStateRepositoryBasedMissionRequestStateReflector extends MissionRequestStateReflector {

    @Autowired
    private MissionRequestStateRepository repository;

    private CreatedMissionRequestState createdMissionRequestState;
    private ApprovedMissionRequestState approvedMissionRequestState;
    private RejectedMissionRequestState rejectedMissionRequestState;
    private CancelledMissionRequestState cancelledMissionRequestState;


    @Override
    public CreatedMissionRequestState getCreatedMissionRequestState() {
        if(createdMissionRequestState == null) {
            createdMissionRequestState = repository.getCreatedMissionRequestState();
            if(createdMissionRequestState == null) {
                createdMissionRequestState = new CreatedMissionRequestState();
                repository.save(createdMissionRequestState);
            }
        }
        return createdMissionRequestState;
    }


    @Override
    public ApprovedMissionRequestState getApprovedMissionRequestState() {
        if(approvedMissionRequestState == null) {
            approvedMissionRequestState = repository.getApprovedMissionRequestState();
            if(approvedMissionRequestState == null) {
                approvedMissionRequestState = new ApprovedMissionRequestState();
                repository.save(approvedMissionRequestState);
            }
        }
        return approvedMissionRequestState;
    }


    @Override
    public RejectedMissionRequestState getRejectedMissionRequestState() {
        if(rejectedMissionRequestState == null) {
            rejectedMissionRequestState = repository.getRejectedMissionRequestState();
            if(rejectedMissionRequestState == null) {
                rejectedMissionRequestState = new RejectedMissionRequestState();
                repository.save(rejectedMissionRequestState);
            }
        }
        return rejectedMissionRequestState;
    }


    @Override
    public CancelledMissionRequestState getCancelledMissionRequestState() {
        if(cancelledMissionRequestState == null) {
            cancelledMissionRequestState = repository.getCancelledMissionRequestState();
            if(cancelledMissionRequestState == null) {
                cancelledMissionRequestState = new CancelledMissionRequestState();
                repository.save(cancelledMissionRequestState);
            }
        }
        return cancelledMissionRequestState;
    }
}
