package ma.ensias.missionrequestservice.config;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import ma.ensias.missionrequestservice.dto.MissionRequestDto;


@Component
@RabbitListener(queues = "mission-request-approved-queue")
public class Receiver {

    @RabbitHandler
    public void receive(MissionRequestDto missionRequestDto) {
        System.out.println(missionRequestDto);
    }

    @RabbitHandler
    public void receive(Message message) {
        System.out.println(message.toString());
    }
    
}