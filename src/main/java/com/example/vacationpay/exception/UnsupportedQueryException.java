package com.example.vacationpay.exception;

/**
 * @author Anatoliy Shikin
 */
public class UnsupportedQueryException extends RuntimeException {
    public UnsupportedQueryException(String message) {
        super(message);
    }
}
