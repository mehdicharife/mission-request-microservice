package ma.ensias.missionrequestservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ma.ensias.missionrequestservice.domain.*;

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
