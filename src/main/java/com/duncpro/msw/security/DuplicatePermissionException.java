package com.duncpro.msw.security;

/**
 * Thrown when a plugin attempts to register a permission by an already existent name.
 */
public class DuplicatePermissionException extends RuntimeException {
    public DuplicatePermissionException(String message) {
        super(message);
    }
}
