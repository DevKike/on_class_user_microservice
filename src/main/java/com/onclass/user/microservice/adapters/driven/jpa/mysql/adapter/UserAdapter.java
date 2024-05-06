package com.onclass.user.microservice.adapters.driven.jpa.mysql.adapter;

import com.onclass.user.microservice.adapters.driven.jpa.mysql.entity.RoleEntity;
import com.onclass.user.microservice.adapters.driven.jpa.mysql.entity.UserEntity;
import com.onclass.user.microservice.adapters.driven.jpa.mysql.exception.DocumentAlreadyExistsException;
import com.onclass.user.microservice.adapters.driven.jpa.mysql.exception.EmailAlreadyExistsException;
import com.onclass.user.microservice.adapters.driven.jpa.mysql.exception.NotFoundException;
import com.onclass.user.microservice.adapters.driven.jpa.mysql.mapper.IUserEntityMapper;
import com.onclass.user.microservice.adapters.driven.jpa.mysql.repository.IRoleRepository;
import com.onclass.user.microservice.adapters.driven.jpa.mysql.repository.IUserRepository;
import com.onclass.user.microservice.domain.model.User;
import com.onclass.user.microservice.domain.spi.IUserPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
public class UserAdapter implements IUserPersistencePort {
    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;
    private final IRoleRepository roleRepository;

    @Override
    public void createUserAsAdmin(User user) {
        List<UserEntity> usersByDocument = userRepository.findByDocument(user.getDocument());

        if (!usersByDocument.isEmpty()) {
            throw new DocumentAlreadyExistsException();
        }

        List<UserEntity> usersByEmail = userRepository.findByEmail(user.getEmail());

        if (!usersByEmail.isEmpty()) {
            throw new EmailAlreadyExistsException();
        }

        List<String> adminRoleNames = Arrays.asList("admin", "Admin", "administrator", "Administrator");

        RoleEntity adminRole = roleRepository.findByNameIn(adminRoleNames)
                .orElseThrow(NotFoundException::new);

        UserEntity userEntity = userEntityMapper.toEntity(user);
        userEntity.setRole(adminRole);

        userRepository.save(userEntity);
    }
}