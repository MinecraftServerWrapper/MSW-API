package com.duncpro.msw.command.basic;

import com.duncpro.msw.command.CommandDocumentation;
import com.duncpro.msw.command.CommandUsage;
import com.duncpro.msw.util.Preconditions;

import java.util.HashSet;
import java.util.Set;

/**
 * Utility for creating {@link BasicCommandDocumentation}s quickly.
 */
public class CommandDocumentationBuilder {
    private String commandDescription;
    private Set<CommandUsage> usages = new HashSet<>();

    /**
     * Constructs {@link CommandDocumentationBuilder}.
     */
    public CommandDocumentationBuilder() {}

    /**
     * Adds the specified {@link CommandUsage} to the list of usages for
     * this command.
     *
     * @param usage the usage to add (cant be null)
     * @return this builder
     */
    public CommandDocumentationBuilder withUsage(CommandUsage usage) {
        Preconditions.notNull(usage, "usage cant be null");
        if (usages.contains(usage)) {
            throw new IllegalArgumentException("Usage: " + usage + " is already defined.");
        }
        usages.add(usage);
        return this;
    }

    /**
     * Adds the specified {@link CommandUsage}s to the list of usages for
     * this command.
     * @param usages the usage to add (cant be null)
     * @return this builder
     */
    public CommandDocumentationBuilder withUsages(CommandUsage... usages) {
        Preconditions.notNull(usages, "usages cant be null");
        for (CommandUsage usage : usages) {
            withUsage(usage);
        }
        Preconditions.notNull(usages, "usages cant be null");
        return this;
    }

    /**
     * Sets the description for this command.
     * This can be null if no description is needed.
     *
     * @param description the description
     * @return this builder
     */
    public CommandDocumentationBuilder withCommandDescription(String description) {
        this.commandDescription = description;
        return this;
    }

    /**
     * Builds a {@link CommandDocumentation} with all of the defined properties.
     *
     * @return the {@link CommandDocumentation}
     */
    public CommandDocumentation build() {
        return new BasicCommandDocumentation(commandDescription, usages);
    }
}
