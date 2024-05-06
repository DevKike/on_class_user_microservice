package com.onclass.user.microservice.configuration.user;

import com.onclass.user.microservice.adapters.driven.jpa.mysql.adapter.UserAdapter;
import com.onclass.user.microservice.adapters.driven.jpa.mysql.mapper.IUserEntityMapper;
import com.onclass.user.microservice.adapters.driven.jpa.mysql.repository.IRoleRepository;
import com.onclass.user.microservice.adapters.driven.jpa.mysql.repository.IUserRepository;
import com.onclass.user.microservice.domain.api.IUserServicePort;
import com.onclass.user.microservice.domain.api.usecase.UserUseCase;
import com.onclass.user.microservice.domain.spi.IBcryptPersistencePort;
import com.onclass.user.microservice.domain.spi.IUserPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class UserBeanConfiguration {
    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;
    private final IBcryptPersistencePort bcryptPersistencePort;
    private final IRoleRepository roleRepository;

    @Bean
    public IUserPersistencePort userPersistencePort() {
        return new UserAdapter(userRepository, userEntityMapper, roleRepository);
    }

    @Bean
    public IUserServicePort userServicePort() {
        return new UserUseCase(userPersistencePort(), bcryptPersistencePort);
    }
}