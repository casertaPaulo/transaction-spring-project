package com.myproject.transactions.dto;

import com.myproject.transactions.entity.enums.UserType;

import java.math.BigDecimal;

public record CreateUserDTO(
        Long id,
        String fullName,
        String document,
        String email,
        String password,
        BigDecimal balance,
        UserType userType
) { }
