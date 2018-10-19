package com.example.gcppubsubexample;

import com.example.gcppubsubexample.domain.User;
import com.example.gcppubsubexample.domain.event.Channels;
import com.example.gcppubsubexample.domain.event.UserRegistered;
import com.example.gcppubsubexample.publisher.EventPublisher;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.Instant;
import java.util.UUID;

@Slf4j
@EnableScheduling
@EnableBinding(Channels.class)
@SpringBootApplication
@RequiredArgsConstructor
public class GcpPubsubExampleApplication {

    private final EventPublisher eventPublisher;

    public static void main(String[] args) {
        SpringApplication.run(GcpPubsubExampleApplication.class, args);
    }

    @Scheduled(fixedRate = 20000L)
    public void randomEvent() {
        User user = User.builder().id(UUID.randomUUID()).username("johndoe").password("password123").build();
        eventPublisher.sendEvent(new UserRegistered(user, Instant.now()));
    }

    @StreamListener("input")
    public void handleEvent(UserRegistered event) {
        log.info("User Registered event received {}", event.toString());
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        return mapper;
    }
}
