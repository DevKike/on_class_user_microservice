package com.onclass.user.microservice.adapters.driven.jpa.mysql.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name field cannot be empty")
    private String name;

    @NotBlank(message = "Last name field cannot be empty")
    private String lastName;

    @Column(unique = true)
    @NotBlank(message = "Document field cannot be empty")
    private String document;

    @Column(unique = true)
    @NotBlank(message = "Email field cannot be empty")
    private String email;

    @Column(length = 14)
    @NotBlank(message = "Phone number field cannot be empty")
    private String phoneNumber;

    @NotBlank(message = "Password field cannot be empty")
    private String password;

    @ManyToOne
    @JoinColumn(name = "id_role")
    private RoleEntity role;
}