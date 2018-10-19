package com.example.gcppubsubexample.domain.event;

import com.example.gcppubsubexample.domain.User;
import lombok.*;

import java.time.Instant;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserRegistered implements DomainEvent {

    private User user;
    private Instant when;

    @Override
    public Instant occuredAt() {
        return when;
    }
}
