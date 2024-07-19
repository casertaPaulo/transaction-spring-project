package com.myproject.transactions.exception.user;

import com.myproject.transactions.entity.enums.UserTransactionType;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("USER NOT FOUND");
    }

    public UserNotFoundException (UserTransactionType userTransactionType) {
        super(userTransactionType.name() + " NOT FOUND");
    }
}
