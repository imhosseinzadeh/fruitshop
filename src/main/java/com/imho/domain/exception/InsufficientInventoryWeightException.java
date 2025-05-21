package com.imho.domain.exception;

public class InsufficientInventoryWeightException extends RuntimeException {
    public InsufficientInventoryWeightException(String message) {
        super(message);
    }
}
