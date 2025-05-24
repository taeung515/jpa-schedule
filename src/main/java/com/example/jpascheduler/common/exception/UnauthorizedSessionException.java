package com.example.jpascheduler.common.exception;

public class UnauthorizedSessionException extends RuntimeException {
    public UnauthorizedSessionException(String message) {
        super(message);
    }
}
