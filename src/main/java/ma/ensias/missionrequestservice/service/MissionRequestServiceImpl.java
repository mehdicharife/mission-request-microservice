package ma.ensias.missionrequestservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import ma.ensias.missionrequestservice.domain.MissionRequest;
import ma.ensias.missionrequestservice.reflector.MissionRequestStateRepositoryBasedMissionRequestStateReflector;
import ma.ensias.missionrequestservice.repository.MissionRequestRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class MissionRequestServiceImpl implements MissionRequestService {
    @Autowired
    private MissionRequestRepository missionRequestRepository;

    @Autowired
    private MissionRequestStateRepositoryBasedMissionRequestStateReflector stateReflector;


    List<MissionRequest> missionRequests;

    @PostConstruct
    public void init() {
        missionRequests = new ArrayList<>();
        missionRequests.add(new MissionRequest((long) 1, (long) 2, (long) 3));
        missionRequests.add(new MissionRequest((long) 4, (long) 5, (long) 6));
        missionRequests.add(new MissionRequest((long) 7, (long) 8, (long) 9));
    }

    public List<MissionRequest> getMissionRequests() {
        //return this.missionRequestRepository.findAll();
        return missionRequests;
    }

    public Optional<MissionRequest> getMissionRequestById(Long id) {
        return missionRequestRepository.findById(id);
    }

    public MissionRequest save(MissionRequest missionRequest) {
        MissionRequest saveableMissionRequest = missionRequest.copy(stateReflector);
        System.out.println(saveableMissionRequest);
        return missionRequestRepository.save(saveableMissionRequest);
    }

    public List<MissionRequest> getMissionRequestsByProfessorId(Long profId) {
        List<MissionRequest> requests = new ArrayList<MissionRequest>();
        requests.add(new MissionRequest((long) 1, (long) 2, (long) 3));
        return requests;
        //return this.missionRequestRepository.findByProfessorId(profId);
    }
}
