package com.myproject.transactions.exception;

public class DocumentAlreadyExistException extends RuntimeException {
    public DocumentAlreadyExistException() {
        super("DOCUMENT NUMBER ALREADY EXIST IN DATABASE");
    }
}
