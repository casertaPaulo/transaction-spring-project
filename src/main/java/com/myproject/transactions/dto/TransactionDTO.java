package com.myproject.transactions.dto;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class TransactionDTO {

    private Long senderId;
    private Long receiverId;
    private BigDecimal amount;
}
