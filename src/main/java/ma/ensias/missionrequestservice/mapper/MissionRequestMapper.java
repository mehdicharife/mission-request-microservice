package ma.ensias.missionrequestservice.mapper;


import ma.ensias.missionrequestservice.domain.MissionRequest;
import ma.ensias.missionrequestservice.dto.MissionRequestDto;
import ma.ensias.missionrequestservice.namer.MissionRequestStateNamer;
import ma.ensias.missionrequestservice.namer.NamePerSubTypeMissionRequestStateNamer;


public class MissionRequestMapper {

    private static MissionRequestStateNamer missionRequestStateNamer = new NamePerSubTypeMissionRequestStateNamer();

    public static MissionRequestDto toDto(MissionRequest missionRequest) {
        MissionRequestDto missionRequestDto = new MissionRequestDto();

        missionRequestDto.setId(missionRequest.getId());
        missionRequestDto.setProfessorId(missionRequest.getProfessorId());
        missionRequestDto.setMissionId(missionRequest.getMissionId());
        missionRequestDto.setState(missionRequestStateNamer.getName(missionRequest.getMissionRequestStateCopy()));

        return missionRequestDto;
    }
}
