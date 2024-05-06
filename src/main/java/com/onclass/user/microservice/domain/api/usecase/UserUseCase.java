package com.onclass.user.microservice.domain.api.usecase;

import com.onclass.user.microservice.domain.api.IUserServicePort;
import com.onclass.user.microservice.domain.exception.InvalidEmailException;
import com.onclass.user.microservice.domain.model.User;
import com.onclass.user.microservice.domain.spi.IBcryptPersistencePort;
import com.onclass.user.microservice.domain.spi.IUserPersistencePort;
import com.onclass.user.microservice.domain.util.EmailValidator;

public class UserUseCase implements IUserServicePort {
    private final IUserPersistencePort userPersistencePort;
    private final IBcryptPersistencePort bcryptPersistencePort;

    public UserUseCase(IUserPersistencePort userPersistencePort, IBcryptPersistencePort bcryptPersistencePort) {
        this.userPersistencePort = userPersistencePort;
        this.bcryptPersistencePort = bcryptPersistencePort;
    }

    @Override
    public void createUser(User user) {
        if (!EmailValidator.isValidEmail(user.getEmail())) {
            throw new InvalidEmailException();
        }

        String encryptedPassword = bcryptPersistencePort.encrypt(user.getPassword());
        user.setPassword(encryptedPassword);

        userPersistencePort.createUserAsAdmin(user);
    }
}