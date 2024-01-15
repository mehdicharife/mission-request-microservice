package ma.ensias.missionrequestservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ma.ensias.missionrequestservice.domain.MissionRequest;
import ma.ensias.missionrequestservice.factory.MissionRequestStateFactory;
import ma.ensias.missionrequestservice.repository.MissionRequestStateRepository;
import ma.ensias.missionrequestservice.service.MissionRequestService;

@SpringBootApplication
public class MissionRequestServiceApplication {

	@Autowired
	private MissionRequestService missionRequestService;

	@Bean
	CommandLineRunner run(MissionRequestStateFactory missionRequestStateFactory) {
		return args -> {
			MissionRequest request1 = new MissionRequest();
			missionRequestService.save(request1);

			MissionRequest request2 = new MissionRequest();
			request2.approve();
			missionRequestService.save(request2);

			MissionRequest request3 = new MissionRequest();
			request3.reject();
			missionRequestService.save(request3);

			MissionRequest request4 = new MissionRequest();
			missionRequestService.save(request4);

			MissionRequest request5 = new MissionRequest();
			request5.reject();
			missionRequestService.save(request5);

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(MissionRequestServiceApplication.class, args);
	}

}
