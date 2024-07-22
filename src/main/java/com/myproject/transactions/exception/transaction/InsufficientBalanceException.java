package com.myproject.transactions.exception.transaction;

import com.myproject.transactions.exception.PicPayException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class InsufficientBalanceException extends PicPayException {
    @Override
    public ProblemDetail toProblemDetail() {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        problemDetail.setTitle("Insufficient founds to complete transaction.");
        problemDetail.setDetail("The sender does not have founds enough to complete the operation.");

        return problemDetail;
    }
}
