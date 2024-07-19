package com.myproject.transactions.exception.transaction;

public class InsufficientBalance extends RuntimeException{
    public InsufficientBalance() {
        super("INSUFFICIENT FUNDS");
    }
}
