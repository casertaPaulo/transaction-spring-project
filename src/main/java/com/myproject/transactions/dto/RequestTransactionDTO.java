package com.myproject.transactions.dto;

import java.math.BigDecimal;

public record RequestTransactionDTO(
        Long senderId,
        Long receiverId,
        BigDecimal amount
) {

}
