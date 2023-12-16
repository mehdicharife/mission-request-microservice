package ensias.ma.missionrequestservice.namers;

import ensias.ma.missionrequestservice.domain.MissionRequestState;


public interface MissionRequestStateNamer {
    String getName(MissionRequestState missionRequestState);
}
