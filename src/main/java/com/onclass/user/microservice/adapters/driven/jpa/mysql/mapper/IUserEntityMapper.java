package com.onclass.user.microservice.adapters.driven.jpa.mysql.mapper;

import com.onclass.user.microservice.adapters.driven.jpa.mysql.entity.UserEntity;
import com.onclass.user.microservice.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IUserEntityMapper {
    @Mapping(target = "role", ignore = true)
    UserEntity toEntity(User user);
}