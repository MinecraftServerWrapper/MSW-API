package com.duncpro.msw.command.plugin;

import com.duncpro.msw.command.Command;
import com.duncpro.msw.plugin.Plugin;

/**
 * Represents a command that was created by a plugin.
 */
public abstract class PluginIdentifiableCommand extends Command {
    /**
     * Returns the plugin that created this command.
     *
     * @return the plugin that created this command.
     */
    public abstract Plugin getPlugin();
}
