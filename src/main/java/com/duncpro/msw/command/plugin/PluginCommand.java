package com.duncpro.msw.command.plugin;


import com.duncpro.msw.command.CommandDocumentation;
import com.duncpro.msw.command.CommandExecutor;
import com.duncpro.msw.command.CommandSender;
import com.duncpro.msw.plugin.Plugin;
import com.duncpro.msw.security.plugin.PluginIdentifiablePermission;
import com.duncpro.msw.util.Preconditions;

import java.util.Collections;
import java.util.Set;

/**
 * Implementation of {@link com.duncpro.msw.command.Command} for use by plugins.
 */
public class PluginCommand extends PluginIdentifiableCommand {
    private String name;
    private Set<String> aliases;
    private PluginIdentifiablePermission requiredPermission;
    private CommandDocumentation documentation;
    private CommandExecutor executor;
    private Plugin plugin;

    /**
     * Creates a PluginCommand.
     *
     * @param name the name of the command
     * @param aliases aliases for the name of the command
     * @param documentation documentation for the command
     * @param executor the command's executor
     * @param plugin the plugin that created the command
     */
    public PluginCommand(String name, Set<String> aliases, PluginIdentifiablePermission requiredPermission, CommandDocumentation documentation, CommandExecutor executor, Plugin plugin) {
        Preconditions.notNull(name, "command name cant be null");
        Preconditions.notNull(aliases, "alias list cant be null, use empty list instead");
        this.name = name;
        this.aliases = aliases;
        if (requiredPermission != null) {
            if (!requiredPermission.getPlugin().equals(plugin)) {
                throw new IllegalArgumentException("Cannot assign permission (" + requiredPermission +
                        " from plugin: " + requiredPermission.getPlugin().getDescription().getTitle()
                        + ") to command owned by different plugin ( " + plugin.getDescription().getTitle() + ").");
            }
        }
        this.requiredPermission = requiredPermission;
        this.documentation = documentation;
        this.executor = executor;
        this.plugin = plugin;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Set<String> getAliases() {
        return Collections.unmodifiableSet(aliases);
    }

    @Override
    public PluginIdentifiablePermission getRequiredPermission() {
        return requiredPermission;
    }

    @Override
    public CommandDocumentation getDocumentation() {
        return documentation;
    }

    public void setDocumentation(CommandDocumentation documentation) {
        this.documentation = documentation;
    }

    @Override
    public boolean hasDocumentation() {
        return documentation != null;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        executor.execute(this, sender, args);
    }

    public Plugin getPlugin() {
        return plugin;
    }

    public CommandExecutor getExecutor() {
        return executor;
    }
}
