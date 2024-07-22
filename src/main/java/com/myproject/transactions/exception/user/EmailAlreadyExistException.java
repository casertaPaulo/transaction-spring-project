package com.myproject.transactions.exception.user;

import com.myproject.transactions.exception.PicPayException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class EmailAlreadyExistException extends PicPayException {

    @Override
    public ProblemDetail toProblemDetail() {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        problemDetail.setTitle("E-mail already exists in database.");
        problemDetail.setDetail("Already exists a user with this e-mail.");

        return problemDetail;
    }
}
