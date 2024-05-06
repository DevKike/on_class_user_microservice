package com.onclass.user.microservice.domain.api;

import com.onclass.user.microservice.domain.model.User;

public interface IUserServicePort {
    void createUser(User user);
}