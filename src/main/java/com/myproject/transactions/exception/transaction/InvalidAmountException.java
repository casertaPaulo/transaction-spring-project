package com.myproject.transactions.exception.transaction;

import com.myproject.transactions.exception.PicPayException;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class InvalidAmountException extends PicPayException {

    @Override
    public ProblemDetail toProblemDetail() {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        problemDetail.setTitle("Invalid amount.");
        problemDetail.setDetail("The amount value is invalid to complete the operation.");
        return problemDetail;
    }
}
