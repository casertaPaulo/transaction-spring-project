package com.myproject.transactions.exception.user;

import com.myproject.transactions.exception.PicPayException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class DocumentAlreadyExistException extends PicPayException {

    // Overriding Super's method
    @Override
    public ProblemDetail toProblemDetail() {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        problemDetail.setTitle("User already exists.");
        problemDetail.setDetail("Document already registered in database.");

        return problemDetail;
    }
}
