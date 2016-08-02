package com.duncpro.msw.security;

/**
 * Represents the description of a permission. All {@link Permission}s must
 * have a corresponding description.
 */
public class PermissionDocumentation {
    private String description;

    /**
     * Constructs a PermissionDocumentation.
     * @param description the description string
     */
    public PermissionDocumentation(String description) {
        this.description = description;
    }

    /**
     * Constructs PermissionDescription with no description string.
     */
    public PermissionDocumentation() {
        this(null);
    }

    /**
     * Returns this PermissionDescription's description string. If none was
     * defined then null is returned.
     *
     * Keep in mind that a description string is optional.
     *
     * @return this permissions description string.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns true if this PermissionDescription has a description string.
     *
     * @return true if this PermissionDescription has a description string.
     */
    public boolean hasDescription() {
        return description != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PermissionDocumentation that = (PermissionDocumentation) o;

        return description != null ? description.equals(that.description) : that.description == null;

    }

    @Override
    public int hashCode() {
        return description != null ? description.hashCode() : 0;
    }
}
