package com.example.springbootdocker.exception;

public class OverLimitQuantityException extends Exception {
    public OverLimitQuantityException() {

    }

    public OverLimitQuantityException(String message) {
        super(message);
    }
}
