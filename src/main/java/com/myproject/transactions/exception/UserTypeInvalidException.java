package com.myproject.transactions.exception;

public class UserTypeInvalidException extends RuntimeException{
    public UserTypeInvalidException() {
        super("SELLER CANNOT REALIZE TRANSACTION");
    }
}
