package com.myproject.transactions.exception.transaction;

import com.myproject.transactions.exception.PicPayException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class UserTypeInvalidException extends PicPayException {

    @Override
    public ProblemDetail toProblemDetail() {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problemDetail.setTitle("Seller cannot do transaction.");
        problemDetail.setDetail("Only 'COMMON' users can be senders in transactions.");

        return problemDetail;
    }
}
