package mpetok.todo.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {


    @KafkaListener(topics = "mytopic", groupId = "mygroup")
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
    }
}
