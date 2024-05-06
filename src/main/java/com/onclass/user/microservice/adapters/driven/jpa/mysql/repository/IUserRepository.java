package com.onclass.user.microservice.adapters.driven.jpa.mysql.repository;

import com.onclass.user.microservice.adapters.driven.jpa.mysql.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findByDocument(String document);
    List<UserEntity> findByEmail(String email);
}