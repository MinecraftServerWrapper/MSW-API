package com.duncpro.msw.command.plugin;

import com.duncpro.msw.plugin.Plugin;

/**
 * Represents a complete list of the wrapper's executable commands.
 */
public interface CommandRegistry {
    /**
     * Adds a command that can be executed.
     *
     * @param command the command to add
     */
    void registerCommand(PluginIdentifiableCommand command);

    /**
     * Removes a command from the registry. This command will no longer be executed.
     * This also removes all of the commands aliases.
     *
     * @param command the command to remove
     */
    void removeCommand(PluginIdentifiableCommand command);

    /**
     * Removes a command along with all its aliases from the registry. This command will no longer
     * be executed.
     *
     * Note this method can only be used to remove commands registered by plugins.
     *
     * @param commandName the primary name of the command
     */
    void removeCommand(String commandName);
    /**
     * Removes all commands registered by a specific plugin from the registry. These commands will no longer
     * be executed.
     *
     * @param plugin the plugin
     */
    void removeAllCommands(Plugin plugin);
}
