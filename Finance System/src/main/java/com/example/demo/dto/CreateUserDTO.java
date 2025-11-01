package com.example.demo.dto;

import com.example.demo.models.RoleName;

public record CreateUserDTO (
        String email,
        String password,
        RoleName role
    )
{}
