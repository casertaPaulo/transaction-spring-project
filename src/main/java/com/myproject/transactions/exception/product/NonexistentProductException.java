package com.myproject.transactions.exception.product;

import com.myproject.transactions.exception.PicPayException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class NonexistentProductException extends PicPayException {

    private final Long id;

    public NonexistentProductException(Long id) {
        this.id = id;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);

        problemDetail.setTitle("Product not found.");
        problemDetail.setDetail("Nonexistent product with ID: " + id);

        return problemDetail;
    }
}
