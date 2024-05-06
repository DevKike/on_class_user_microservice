package com.onclass.user.microservice.domain.spi;

public interface IBcryptPersistencePort {
    String encrypt(String password);
}