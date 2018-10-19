package com.example.gcppubsubexample.domain.event;

import java.time.Instant;

public interface DomainEvent {

    public Instant occuredAt();
}