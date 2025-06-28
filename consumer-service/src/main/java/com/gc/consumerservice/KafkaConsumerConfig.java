package com.gc.consumerservice;

import com.gc.consumerservice.dto.UserCreatedEvent;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {
    @Bean
    public ConsumerFactory<String, UserCreatedEvent> consumerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        return new DefaultKafkaConsumerFactory<>(config
                , new StringDeserializer()
                , new JsonDeserializer<>(UserCreatedEvent.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, UserCreatedEvent> kafkaListenerContainerFactory() {
        var factory = new ConcurrentKafkaListenerContainerFactory<String, UserCreatedEvent>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
