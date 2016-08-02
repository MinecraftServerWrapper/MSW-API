package com.duncpro.msw.command;

import java.util.Set;

/**
 * Information about a specific command.
 */
public abstract class CommandDocumentation {
    /**
     * A brief description of the command.
     * If no command description has been provided then null is returned.
     *
     * @return A description of the command.
     */
    public abstract String getCommandDescription();

    /**
     * Returns true if a command description has been provided.
     *
     * @return true if a command description has been provided.
     */
    public boolean hasCommandDescription() {
        return getCommandDescription() != null;
    }

    /**
     * Returns a list of usages for this command.
     * If no usages have been provided then an empty set is returned.
     *
     * @return a list of usages for this command.
     */
    public abstract Set<CommandUsage> getUsages();

    /**
     * Returns true if at least one usage has been provided for this command.
     *
     * @return true if the command has at least one usage.
     */
    public boolean hasUsages() {
        return !getUsages().isEmpty();
    }
}
