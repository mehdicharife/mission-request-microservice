package ensias.ma.missionrequestservice;

import ensias.ma.missionrequestservice.domain.CreatedMissionRequestState;
import ensias.ma.missionrequestservice.domain.MissionRequestStateFactory;
import ensias.ma.missionrequestservice.repositories.MissionRequestStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MissionRequestServiceApplication {

	@Autowired
	MissionRequestStateRepository repository;

	@Bean
	CommandLineRunner run(MissionRequestStateFactory missionRequestStateFactory) {
		return args -> {
			System.out.println(missionRequestStateFactory.getCreatedMissionRequestState().getId());
			System.out.println(missionRequestStateFactory.getCancelledMissionRequestState().getId());
			System.out.println(missionRequestStateFactory.getApprovedMissionRequestState().getId());
			System.out.println(missionRequestStateFactory.getRejectedMissionRequestState().getId());
			System.out.println(missionRequestStateFactory.getRejectedMissionRequestState().getId());
			System.out.println(missionRequestStateFactory.getApprovedMissionRequestState().getId());
			System.out.println(missionRequestStateFactory.getCancelledMissionRequestState().getId());
			System.out.println(missionRequestStateFactory.getCreatedMissionRequestState().getId());
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(MissionRequestServiceApplication.class, args);
	}

}
