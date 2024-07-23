package com.myproject.transactions.service;

// Implementing interface for services that need validate something.
public interface Validate<T> {
    void validate(T entity);
}
