package com.onclass.user.microservice.domain.spi;

import com.onclass.user.microservice.domain.model.User;

public interface IUserPersistencePort {
    void createUserAsAdmin(User user);
}