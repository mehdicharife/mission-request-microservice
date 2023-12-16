package ma.ensias.missionrequestservice.namers;

import ma.ensias.missionrequestservice.domain.MissionRequestState;


public interface MissionRequestStateNamer {
    String getName(MissionRequestState missionRequestState);
}
