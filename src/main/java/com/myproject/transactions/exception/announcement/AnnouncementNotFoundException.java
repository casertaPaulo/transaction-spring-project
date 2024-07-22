package com.myproject.transactions.exception.announcement;

import com.myproject.transactions.exception.PicPayException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class AnnouncementNotFoundException extends PicPayException {
    private final String id;

    public AnnouncementNotFoundException(String id) {
        this.id = id;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);

        problemDetail.setTitle("Announcement not found.");
        problemDetail.setDetail("None exists announcement with ID: " + id);

        return problemDetail;
    }
}
