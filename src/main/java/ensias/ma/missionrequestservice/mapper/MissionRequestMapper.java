package ensias.ma.missionrequestservice.mapper;


import ensias.ma.missionrequestservice.domain.MissionRequest;
import ensias.ma.missionrequestservice.dto.MissionRequestDto;
import ensias.ma.missionrequestservice.namers.MissionRequestStateNamer;
import ensias.ma.missionrequestservice.namers.NamePerSubTypeMissionRequestStateNamer;


public class MissionRequestMapper {

    private static MissionRequestStateNamer missionRequestStateNamer = new NamePerSubTypeMissionRequestStateNamer();

    public static MissionRequestDto toDto(MissionRequest missionRequest) {
        MissionRequestDto missionRequestDto = new MissionRequestDto();

        missionRequestDto.setId(missionRequest.getId());
        missionRequestDto.setProfessorId(missionRequest.getProfessorId());
        missionRequestDto.setMissionDetails(missionRequest.getMissionDetails());
        missionRequestDto.setState(missionRequestStateNamer.getName(missionRequest.getMissionRequestState()));

        return missionRequestDto;
    }
}
