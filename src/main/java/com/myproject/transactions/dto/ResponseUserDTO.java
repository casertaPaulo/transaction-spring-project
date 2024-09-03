package com.myproject.transactions.dto;

import java.math.BigDecimal;

public record ResponseUserDTO(
        String fullName,
        String document,
        String email,
        BigDecimal balance
) { }
