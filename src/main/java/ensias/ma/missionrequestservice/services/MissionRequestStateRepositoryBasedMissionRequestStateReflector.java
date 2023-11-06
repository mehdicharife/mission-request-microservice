package ensias.ma.missionrequestservice.services;

import ensias.ma.missionrequestservice.domain.*;
import ensias.ma.missionrequestservice.repositories.MissionRequestStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public final class  MissionRequestStateRepositoryBasedMissionRequestStateReflector extends MissionRequestStateReflector {
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
        }
        return createdMissionRequestState;
    }

    @Override
    public ApprovedMissionRequestState getApprovedMissionRequestState() {
        if(approvedMissionRequestState == null) {
            approvedMissionRequestState = repository.getApprovedMissionRequestState();
        }
        return approvedMissionRequestState;
    }

    @Override
    public RejectedMissionRequestState getRejectedMissionRequestState() {
        if(rejectedMissionRequestState == null) {
            rejectedMissionRequestState = repository.getRejectedMissionRequestState();
        }
        return rejectedMissionRequestState;
    }

    @Override
    public CancelledMissionRequestState getCancelledMissionRequestState() {
        if(cancelledMissionRequestState == null) {
            cancelledMissionRequestState = repository.getCancelledMissionRequestState();
        }
        return cancelledMissionRequestState;
    }
}
