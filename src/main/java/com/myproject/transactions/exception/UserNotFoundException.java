package com.myproject.transactions.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("USER NOT FOUND");
    }

    public UserNotFoundException (String message) {
        super(message);
    }
}
