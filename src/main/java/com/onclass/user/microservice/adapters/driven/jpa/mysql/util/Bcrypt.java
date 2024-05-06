package com.onclass.user.microservice.adapters.driven.jpa.mysql.util;

import com.onclass.user.microservice.domain.spi.IBcryptPersistencePort;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class Bcrypt implements IBcryptPersistencePort {

    @Override
    public String encrypt(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
}