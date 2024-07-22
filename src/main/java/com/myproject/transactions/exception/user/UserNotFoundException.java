package com.myproject.transactions.exception.user;

import com.myproject.transactions.entity.enums.UserTransactionType;
import com.myproject.transactions.exception.PicPayException;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class UserNotFoundException extends PicPayException {

    private final String message;

    public UserNotFoundException() {
        this.message = "USER NOT FOUND";
    }

    public UserNotFoundException (UserTransactionType userTransactionType) {
        this.message = userTransactionType.name() + " NOT FOUND";
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);

        problemDetail.setTitle(message);
        return problemDetail;
    }
}
