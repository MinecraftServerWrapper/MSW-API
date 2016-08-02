package com.duncpro.msw.command.plugin;

import com.duncpro.msw.command.CommandDocumentation;
import com.duncpro.msw.command.CommandExecutor;
import com.duncpro.msw.plugin.Plugin;
import com.duncpro.msw.security.plugin.PluginIdentifiablePermission;
import com.duncpro.msw.util.Preconditions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Utility for creating a {@link PluginCommand}.
 */
public class PluginCommandBuilder {
    private String name;
    private Set<String> aliases;
    private PluginIdentifiablePermission requiredPermission;
    private CommandDocumentation documentation;
    private CommandExecutor executor;
    private Plugin plugin;

    /**
     * Creates a {@link PluginCommand} with only the required information.
     *
     * @param name the name
     * @param executor the executor
     * @param plugin the plugin
     */
    public PluginCommandBuilder(String name, CommandExecutor executor, Plugin plugin) {
        Preconditions.notNull(name, "command name cannot be null");
        Preconditions.notNull(name, "executor cannot be null");

        this.name = name;
        this.aliases = new HashSet<>();
        this.executor = executor;
        this.plugin = plugin;
    }

    /**
     * Provides aliases for the command name. If aliases have previously been added
     * then these will not overwrite them, but just be added to the already existent ones.
     *
     * @param aliases the aliases to add
     * @return this PluginCommandBuilder
     */
    public PluginCommandBuilder withAliases(Set<String> aliases) {
        Preconditions.notNull(aliases, "aliases cant be null");
        this.aliases.addAll(aliases);
        return this;
    }

    /**
     * Provides aliases for the command name. If aliases have previously been added
     * then these will not overwrite them, but just be added to the already existent ones.
     *
     * @param aliases the aliases to add
     * @return this PluginCommandBuilder
     */
    public PluginCommandBuilder withAliases(String... aliases) {
        Preconditions.notNull(aliases, "aliases cant be null");
        this.aliases.addAll(Arrays.asList(aliases));
        return this;
    }

    /**
     * Sets the permission that senders must have to execute this command.
     *
     * @throws IllegalArgumentException if the permission and plugin are owned by differing plugins
     * @param permission the permission
     * @return this PluginCommandBuilder
     */
    public PluginCommandBuilder withRequiredPermission(PluginIdentifiablePermission permission) {
        // By throwing an exception the moment a plugin author does something illegal we make it
        // easier for them to debug their plugin. The alternative would be waiting until the PluginCommand
        // object was constructed to warn them.
        if (permission != null) {
            if (!permission.getPlugin().equals(plugin)) {
                throw new IllegalArgumentException("Cannot assign permission (" + permission +
                        " from plugin: " + permission.getPlugin().getDescription().getTitle()
                        + ") to command owned by different plugin ( " + plugin.getDescription().getTitle() + ").");
            }
        }
        return this;
    }

    /**
     * Provides documentation for the command.
     *
     * @param documentation the documentation
     * @return the PluginCommandBuilder
     */
    public PluginCommandBuilder withDocumentation(CommandDocumentation documentation) {
        this.documentation = documentation;
        return this;
    }

    /**
     * Creates a {@link PluginCommand} with the supplied information.
     *
     * @return creates a {@link PluginCommand} with the supplied info.
     */
    public PluginCommand build() {
        return new PluginCommand(name, aliases, requiredPermission, documentation, executor, plugin);
    }
}
