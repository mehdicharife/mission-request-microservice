package ensias.ma.missionrequestservice.services;

import ensias.ma.missionrequestservice.domain.MissionRequest;

import java.util.List;
import java.util.Optional;

public interface MissionRequestService {
    List<MissionRequest> getMissionRequests();

    Optional<MissionRequest> getMissionRequestById(Long id);

    MissionRequest save(MissionRequest missionRequest);

}
