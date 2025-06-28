package com.gc.userservice.controllers;

import com.gc.userservice.dto.UserCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final KafkaTemplate<String, UserCreatedEvent> kafkaTemplate;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserCreatedEvent event) {
        kafkaTemplate.send("user.created", event);
        return ResponseEntity.ok("User event published");
    }
}
