package com.example.gcppubsubexample.domain;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
@NoArgsConstructor
public class User {

    private UUID id;
    private String username;
    private String password;
}
