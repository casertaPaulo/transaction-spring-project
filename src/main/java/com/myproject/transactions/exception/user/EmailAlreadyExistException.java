package com.myproject.transactions.exception.user;

public class EmailAlreadyExistException extends RuntimeException {
    public EmailAlreadyExistException() {
        super("EMAIL ALREADY EXIST IN DATABASE");
    }
}
