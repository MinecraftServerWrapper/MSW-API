package com.duncpro.msw.command;

import com.duncpro.msw.security.Permission;

import java.util.Set;

/**
 * Represents a command.
 */
public abstract class Command {

    /**
     * Returns the name of this command.
     *
     * @return the name of this command.
     */
    public abstract String getName();

    /**
     * Returns a set of aliases for this command. Aliases are alternative names that
     * can be used to call the command.
     *
     * @return this command's aliases
     */
    public abstract Set<String> getAliases();

    public abstract Permission getRequiredPermission();

    public boolean hasRequiredPermission() {
        return getRequiredPermission() != null;
    }

    /**
     * Returns the {@link CommandDocumentation} associated with this command.
     * If no command documentation was provided then null is returned.
     *
     * @return this command's documentation
     */
    public abstract CommandDocumentation getDocumentation();

    /**
     * Returns true if documentation has been provided for this command.
     *
     * @return true if this command has documentation
     */
    public boolean hasDocumentation() {
        return getDocumentation() != null;
    }

    /**
     * Executes this command.
     *
     * @param sender the command sender
     * @param args the arguments the sender provided
     */
    public abstract void execute(CommandSender sender, String[] args);
}
