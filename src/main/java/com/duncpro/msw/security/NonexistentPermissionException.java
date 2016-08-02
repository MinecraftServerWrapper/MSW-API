package com.duncpro.msw.security;

/**
 * Thrown when a plugin attempts to retrieve or unregister a permission that does not exist.
 */
public class NonexistentPermissionException extends RuntimeException {
    public NonexistentPermissionException(String message) {
        super(message);
    }
}
