package com.gc.consumerservice.listeners;

import com.gc.consumerservice.dto.UserCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
public class UserEventListener {

    @KafkaListener(topics="user.created", groupId = "user-log-group")
    public void listen(UserCreatedEvent event) {
        System.out.println("Received event: " + event.getEmail());
    }

//    @KafkaListener(topics = "user.created", groupId = "user-log-group")
//    public void a(UserCreatedEvent event) {
//        System.out.println("Consumed event: {}" + event.getEmail());
//    }

}
