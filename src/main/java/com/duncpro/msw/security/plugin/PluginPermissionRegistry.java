package com.duncpro.msw.security.plugin;

import com.duncpro.msw.security.PermissionDocumentation;

import java.util.Set;

public interface PluginPermissionRegistry {
    Set<PluginIdentifiablePermission> getRegisteredPermissions();

    PluginIdentifiablePermission getPermission(String name);

    PluginIdentifiablePermission registerPermission(String name, PermissionDocumentation documentation);

    void unregisterPermission(String name);
}
