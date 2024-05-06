package com.onclass.user.microservice.adapters.driven.jpa.mysql.repository;

import com.onclass.user.microservice.adapters.driven.jpa.mysql.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IRoleRepository extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findByNameIn(List<String> names);
}