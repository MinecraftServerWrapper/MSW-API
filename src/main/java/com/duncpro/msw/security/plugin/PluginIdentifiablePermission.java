package com.duncpro.msw.security.plugin;

import com.duncpro.msw.plugin.Plugin;
import com.duncpro.msw.security.Permission;

public interface PluginIdentifiablePermission extends Permission {
    Plugin getPlugin();
}
