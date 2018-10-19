package com.example.gcppubsubexample.domain.event;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface Channels {

    @Input
    SubscribableChannel input();

    @Output
    MessageChannel output();
}
