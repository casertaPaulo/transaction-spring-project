package com.myproject.transactions.exception;

public class InsufficientBalance extends RuntimeException{
    public InsufficientBalance() {
        super("INSUFFICIENT FUNDS");
    }
}
