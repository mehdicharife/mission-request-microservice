package ma.ensias.missionrequestservice.service;

import java.util.List;
import java.util.Optional;

import ma.ensias.missionrequestservice.domain.MissionRequest;

public interface MissionRequestService {
    List<MissionRequest> getMissionRequests();

    Optional<MissionRequest> getMissionRequestById(Long id);

    MissionRequest save(MissionRequest missionRequest);

    List<MissionRequest> getMissionRequestsByProfessorId(Long profId);

}
