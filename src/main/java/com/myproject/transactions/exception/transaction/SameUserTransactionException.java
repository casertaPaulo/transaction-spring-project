package com.myproject.transactions.exception.transaction;

import com.myproject.transactions.exception.PicPayException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class SameUserTransactionException extends PicPayException {

    @Override
    public ProblemDetail toProblemDetail() {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        problemDetail.setTitle("Same sender and receiver user.");
        problemDetail.setDetail("Sender and receiver must be different to complete this operation.");

        return problemDetail;
    }
}
