package com.duncpro.msw.command.basic;

import com.duncpro.msw.command.CommandUsage;
import com.duncpro.msw.util.Preconditions;

/**
 * The default implementation of {@link CommandUsage}.
 */
public class BasicCommandUsage extends CommandUsage {
    private String usage;
    private String description;

    /**
     * Constructs a BasicCommandUsage.
     *
     * @param usage the usage string (cannot be null)
     * @param description the description
     */
    public BasicCommandUsage(String usage, String description) {
        Preconditions.notNull(usage, "usage cant be null");
        this.usage = usage;
        this.description = description;
    }

    /**
     * Constructs a BasicCommandUsage with no description.
     * Use this you think no description is necessary or the
     * overall command usage will suffice.
     * @param usage the usage string
     */
    public BasicCommandUsage(String usage) {
        this(usage, null);
    }

    @Override
    public String getUsage() {
        return usage;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
