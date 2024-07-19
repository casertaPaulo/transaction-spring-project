package com.myproject.transactions.exception.transaction;

public class SameUserTransactionException extends RuntimeException {
    public SameUserTransactionException() {
        super("SAME USER BETWEEN TRANSACTIONS");
    }
}
