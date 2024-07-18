package com.myproject.transactions.exception;

import com.myproject.transactions.entity.UserTransactionType;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("USER NOT FOUND");
    }

    public UserNotFoundException (UserTransactionType userTransactionType) {
        super(userTransactionType.name() + " NOT FOUND");
    }
}
