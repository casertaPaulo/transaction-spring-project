package com.myproject.transactions.exception.announcement;

public class SellerUserTypeException extends RuntimeException{
    public SellerUserTypeException() {
        super("ONLY SELLER CAN MAKE ANNOUNCEMENTS");
    }
}
