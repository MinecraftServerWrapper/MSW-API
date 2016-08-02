package com.duncpro.msw.security.util;

import com.duncpro.msw.security.MalformedPermissionNameException;
import com.duncpro.msw.util.Preconditions;

/**
 * Utility for validating permissions.
 */
public class PermissionValidator {
    /**
     * Throws a {@link MalformedPermissionNameException} if the name is invalid.
     * Names can not include periods ('.').
     *
     * @param name the name of the permission
     * @throws MalformedPermissionNameException if the name is invalid
     */
    public static void validateName(String name) throws MalformedPermissionNameException {
        Preconditions.notNull(name, "permission name cant be null");
        if (!isValidName(name)) {
            throw new MalformedPermissionNameException("Name cannot" +
                    " contain periods ('.'). (Did you mean to use a slash ('/') instead?");
        }
    }

    /**
     * Returns true if the permission name is valid.
     *
     * @param name the name to validate
     * @return true if the permission name is valid
     */
    public static boolean isValidName(String name) {
        Preconditions.notNull(name, "permission name cant be null");
        if (name.contains(".")) return false;
        return true;
    }
}
