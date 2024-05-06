package com.onclass.user.microservice.adapters.driving.http.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RegisterUserRequest {
    private final String name;
    private final String lastName;
    private final String document;
    private final String email;
    private final String phoneNumber;
    private final String password;
}