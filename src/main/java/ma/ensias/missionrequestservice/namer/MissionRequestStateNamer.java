package ma.ensias.missionrequestservice.namer;

import ma.ensias.missionrequestservice.domain.MissionRequestState;


public interface MissionRequestStateNamer {
    String getName(MissionRequestState missionRequestState);
}
