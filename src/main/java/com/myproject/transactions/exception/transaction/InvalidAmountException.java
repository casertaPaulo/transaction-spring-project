package com.myproject.transactions.exception.transaction;

public class InvalidAmountException extends RuntimeException{
    public InvalidAmountException() {
        super("INVALID AMOUNT");
    }
}
