package com.myproject.transactions.exception.transaction;

public class UserTypeInvalidException extends RuntimeException{
    public UserTypeInvalidException() {
        super("SELLER CANNOT REALIZE TRANSACTION");
    }
}
