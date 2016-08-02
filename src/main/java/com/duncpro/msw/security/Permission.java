package com.duncpro.msw.security;

/**
 * Represents a permission.
 */
public interface Permission {
    /**
     * Returns the name of this permission. This will never be null.
     *
     * @return the name of this permission
     */
    String getName();

    /**
     * Returns the documentation of this permission.
     * If no documentation was provided this will return null.
     *
     * @return this will never be null
     */
    PermissionDocumentation getDocumentation();

    boolean hasDocumentation();
}
