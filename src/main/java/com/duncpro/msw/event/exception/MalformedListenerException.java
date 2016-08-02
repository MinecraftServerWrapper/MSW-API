package com.duncpro.msw.event.exception;

/**
 * Thrown when a listener has not been declared properly.
 */
public class MalformedListenerException extends RuntimeException {
    /**
     * Constructs a {@link MalformedListenerException}.
     *
     * @param message the error message
     */
    public MalformedListenerException(String message) {
        super(message);
    }
}
