package com.onclass.user.microservice.adapters.driving.http.controller;

import com.onclass.user.microservice.adapters.driving.http.dto.request.RegisterUserRequest;
import com.onclass.user.microservice.adapters.driving.http.mapper.IUserRequestMapper;
import com.onclass.user.microservice.domain.api.IUserServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserRestControllerAdapter {
    private final IUserServicePort userServicePort;
    private final IUserRequestMapper userRequestMapper;

    @PostMapping("/register/admin")
    public ResponseEntity<Void> registerAdmin(@RequestBody RegisterUserRequest userRequest) {
        userServicePort.createUser(userRequestMapper.registerRequestToUser(userRequest));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}