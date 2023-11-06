package ensias.ma.missionrequestservice.domain;

import org.springframework.stereotype.Component;

public interface MissionRequestStateFactory {
    MissionRequestState getState();
}
