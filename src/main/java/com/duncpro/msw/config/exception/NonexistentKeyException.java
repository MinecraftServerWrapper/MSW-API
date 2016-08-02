package com.duncpro.msw.config.exception;

/**
 * Thrown when a query is performed on a {@link com.duncpro.msw.config.Configuration} and the path does not exist.
 */
public class NonexistentKeyException extends RuntimeException {
    public NonexistentKeyException(String message) {
        super(message);
    }
}
