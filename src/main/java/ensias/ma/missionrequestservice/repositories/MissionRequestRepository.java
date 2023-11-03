package ensias.ma.missionrequestservice.repositories;

import ensias.ma.missionrequestservice.domain.MissionRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissionRequestRepository extends JpaRepository<MissionRequest, Long> {
}
