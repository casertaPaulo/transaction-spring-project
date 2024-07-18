package com.myproject.transactions.exception;

public class EmailAlreadyExistException extends RuntimeException {
    public EmailAlreadyExistException() {
        super("EMAIL ALREADY EXIST IN DATABASE");
    }
}
