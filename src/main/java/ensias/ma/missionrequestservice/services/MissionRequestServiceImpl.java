package ensias.ma.missionrequestservice.services;

import ensias.ma.missionrequestservice.domain.MissionRequest;
import ensias.ma.missionrequestservice.repositories.MissionRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MissionRequestServiceImpl implements MissionRequestService {
    @Autowired
    private MissionRequestRepository missionRequestRepository;

    @Autowired
    private MissionRequestStateRepositoryBasedMissionRequestStateReflector stateReflector;

    public MissionRequest save(MissionRequest missionRequest) {
        MissionRequest saveableMissionRequest = missionRequest.copy(stateReflector);
        return missionRequestRepository.save(saveableMissionRequest);
    }
}
