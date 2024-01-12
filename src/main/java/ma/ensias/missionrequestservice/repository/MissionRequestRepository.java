package ma.ensias.missionrequestservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.ensias.missionrequestservice.domain.MissionRequest;
import java.util.List;


@Repository
public interface MissionRequestRepository extends JpaRepository<MissionRequest, Long> {

    List<MissionRequest> findByProfessorId(Long professorId);
}
