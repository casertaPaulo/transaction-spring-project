package com.myproject.transactions.exception.announcement;

import com.myproject.transactions.exception.PicPayException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class SellerUserTypeException extends PicPayException {

    @Override
    public ProblemDetail toProblemDetail() {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        problemDetail.setTitle("User Type invalid.");
        problemDetail.setDetail("Only seller users can make announcements.");

        return problemDetail;

    }
}
