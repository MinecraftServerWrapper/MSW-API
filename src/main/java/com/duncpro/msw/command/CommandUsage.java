package com.duncpro.msw.command;

import com.duncpro.msw.command.basic.BasicCommandUsage;

/**
 * Usage information for a specific command.
 */
public abstract class CommandUsage {
    /**
     * Returns the parametric usage string for this command.
     * For example:
     * &lt;player&gt; [reason]
     *
     * Formatting Rules:
     * &lt;required argument&gt;
     * [optional argument]
     * @return the usage string
     */
    public abstract String getUsage();

    /**
     * Returns a description of this specific usage.
     * Returns null if no description has been provided for this usage.
     *
     * @return a description of this specific usage.
     */
    public abstract String getDescription();

    /**
     * Returns true if a description has been provided for this usage.
     *
     * @return true if a description has been provided for this usage.
     */
    public boolean hasDescription() {
        return getDescription() != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        BasicCommandUsage that = (BasicCommandUsage) o;

        return getUsage().equals(that.getUsage());

    }

    @Override
    public int hashCode() {
        int result = 23;
        result = 31 * result + getUsage().hashCode();
        return result;
    }
}
