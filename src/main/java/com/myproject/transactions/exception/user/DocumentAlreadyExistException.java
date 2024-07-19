package com.myproject.transactions.exception.user;

public class DocumentAlreadyExistException extends RuntimeException {
    public DocumentAlreadyExistException() {
        super("DOCUMENT NUMBER ALREADY EXIST IN DATABASE");
    }
}
