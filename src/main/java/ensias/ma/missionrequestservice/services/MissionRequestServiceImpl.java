package ensias.ma.missionrequestservice.services;

import ensias.ma.missionrequestservice.domain.MissionRequest;
import ensias.ma.missionrequestservice.repositories.MissionRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissionRequestServiceImpl implements MissionRequestService {
    @Autowired
    private MissionRequestRepository missionRequestRepository;

    @Autowired
    private MissionRequestStateRepositoryBasedMissionRequestStateReflector stateReflector;

    public List<MissionRequest> getMissionRequests() {
        return this.missionRequestRepository.findAll();
    }

    public Optional<MissionRequest> getMissionRequestById(Long id) {
        return missionRequestRepository.findById(id);
    }

    public MissionRequest save(MissionRequest missionRequest) {
        MissionRequest saveableMissionRequest = missionRequest.copy(stateReflector);
        return missionRequestRepository.save(saveableMissionRequest);
    }
}
