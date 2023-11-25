package ensias.ma.missionrequestservice.services;

import ensias.ma.missionrequestservice.domain.MissionRequest;
import org.springframework.stereotype.Service;

public interface MissionRequestService {
    MissionRequest save(MissionRequest missionRequest);
}
