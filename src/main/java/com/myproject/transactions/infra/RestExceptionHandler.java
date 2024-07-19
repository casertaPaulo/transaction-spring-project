package com.myproject.transactions.infra;

import com.myproject.transactions.exception.transaction.InsufficientBalance;
import com.myproject.transactions.exception.transaction.InvalidAmountException;
import com.myproject.transactions.exception.transaction.SameUserTransactionException;
import com.myproject.transactions.exception.transaction.UserTypeInvalidException;
import com.myproject.transactions.exception.user.DocumentAlreadyExistException;
import com.myproject.transactions.exception.user.EmailAlreadyExistException;
import com.myproject.transactions.exception.user.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    private ResponseEntity<String> userNotFoundException(UserNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(DocumentAlreadyExistException.class)
    private ResponseEntity<String> documentAlreadyExistException(DocumentAlreadyExistException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

    @ExceptionHandler(EmailAlreadyExistException.class)
    private ResponseEntity<String> emailAlreadyExistException(EmailAlreadyExistException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

    @ExceptionHandler(UserTypeInvalidException.class)
    private ResponseEntity<String> userTypeInvalidException(UserTypeInvalidException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(InsufficientBalance.class)
    private ResponseEntity<String> insufficientBalance(InsufficientBalance e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(SameUserTransactionException.class)
    private ResponseEntity<String> sameUserTransactionException(SameUserTransactionException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(InvalidAmountException.class)
    private ResponseEntity<String> invalidAmountException(InvalidAmountException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

}
