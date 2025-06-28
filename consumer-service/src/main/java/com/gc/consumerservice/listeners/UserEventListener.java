package com.gc.consumerservice.listeners;

import com.gc.event.dto.UserCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class UserEventListener {
    @KafkaListener(topics = "user.created", groupId = "user-log-group")
    public void listen(UserCreatedEvent event) {
        System.out.println("Received event: " + event.getEmail());
    }
}
