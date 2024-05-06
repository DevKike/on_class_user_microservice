package com.onclass.user.microservice.adapters.driving.http.mapper;

import com.onclass.user.microservice.adapters.driving.http.dto.request.RegisterUserRequest;
import com.onclass.user.microservice.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IUserRequestMapper {
    @Mapping(target = "id", ignore = true)
    User registerRequestToUser(RegisterUserRequest registerUserRequest);
}