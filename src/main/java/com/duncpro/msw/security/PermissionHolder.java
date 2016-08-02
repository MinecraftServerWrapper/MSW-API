package com.duncpro.msw.security;

import java.util.Set;

/**
 * Represents an object that can be assigned {@link Permission}s.
 */
public interface PermissionHolder {
    /**
     * Returns all permissions assigned to this PermissionsHolder.
     *
     * @return all permissions assigned to this PermissionsHolder.
     */
    Set<Permission> getPermissions();

    /**
     * Gives the specified {@link Permission} to this permissions holder.
     *
     * @param permission the specified permission.
     */
    void givePermission(Permission permission);

    /**
     * Revoke the specified {@link Permission} from this PermissionHolder.
     *
     * @param permission the permission to revoke
     */
    void revokePermission(Permission permission);

    /**
     * Returns true if this PermissionHolder has the specified {@link Permission}.
     *
     * @param permission the permission to check
     * @return true if PermissionHolder has permission
     */
    boolean hasPermission(Permission permission);
}
