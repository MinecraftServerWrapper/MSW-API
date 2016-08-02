package com.duncpro.msw.command.basic;

import com.duncpro.msw.command.CommandDocumentation;
import com.duncpro.msw.command.CommandUsage;
import com.duncpro.msw.util.Preconditions;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * The default implementation of {@link CommandDocumentation}.
 */
public class BasicCommandDocumentation extends CommandDocumentation {
    private String description;
    private Set<CommandUsage> usages = new HashSet<>();

    /**
     * Constructs a BasicCommandDocumentation.
     *
     * @param description the description of the command. (this can be null)
     * @param usages the usages ({@link CommandUsage}) for this command. This cannot be null
     *               but if you don't want to define usages you can supply an empty set.
     *
     */
    public BasicCommandDocumentation(String description, Set<CommandUsage> usages) {
        Preconditions.notNull(usages, "usages cant be null, use empty set instead.");
        this.description = description;
        this.usages = usages;
    }

    @Override
    public Set<CommandUsage> getUsages() {
        return Collections.unmodifiableSet(usages);
    }

    @Override
    public String getCommandDescription() {
        return description;
    }
}
