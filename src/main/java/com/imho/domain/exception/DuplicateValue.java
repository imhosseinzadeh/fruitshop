package com.imho.domain.exception;

public class DuplicateValue extends RuntimeException {
    public DuplicateValue(String message) {
        super(message);
    }
}
