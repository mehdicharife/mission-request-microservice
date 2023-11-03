package ensias.ma.missionrequestservice.repositories;

import ensias.ma.missionrequestservice.domain.MissionRequest;
import ensias.ma.missionrequestservice.domain.MissionRequestState;
import ensias.ma.missionrequestservice.domain.MissionRequestStateVisitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("customMissionRequestRepository")
public class CustomMissionRequestRepository implements MissionRequestRepository, MissionRequestStateVisitor {

    @Autowired
    @Qualifier("missionRequestRepository")
    private MissionRequestRepository missionRequestRepository;

    private MissionRequestState state;

    @Override
    public MissionRequest save(MissionRequest missionRequest) {


        return missionRequestRepository.save(missionRequest);
    }
}
