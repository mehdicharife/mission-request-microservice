package ensias.ma.missionrequestservice.repositories;

import ensias.ma.missionrequestservice.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MissionRequestStateRepository extends JpaRepository<MissionRequestState, Long> {

    @Query("from CreatedMissionRequestState")
    CreatedMissionRequestState getCreatedMissionRequestState();

    @Query("from ApprovedMissionRequestState")
    ApprovedMissionRequestState getApprovedMissionRequestState();

    @Query("from RejectedMissionRequestState")
    RejectedMissionRequestState getRejectedMissionRequestState();

    @Query("from CancelledMissionRequestState")
    CancelledMissionRequestState getCancelledMissionRequestState();
}
