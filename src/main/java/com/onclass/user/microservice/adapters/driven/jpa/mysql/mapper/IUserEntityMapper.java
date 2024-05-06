package com.onclass.user.microservice.adapters.driven.jpa.mysql.mapper;

import com.onclass.user.microservice.adapters.driven.jpa.mysql.entity.UserEntity;
import com.onclass.user.microservice.domain.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IUserEntityMapper {
    UserEntity toEntity(User user);
}