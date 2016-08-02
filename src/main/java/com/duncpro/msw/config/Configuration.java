package com.duncpro.msw.config;

import com.duncpro.msw.util.Preconditions;

import java.util.Map;

/**
 * Represents a configuration.
 */
public abstract class Configuration extends Configurable {
    public static final String PATH_DELIMITER = "\\.";

    /**
     * Returns a map containing the key value pairs of a configuration.
     * ConfigurationSections are represented as {@link Map}s. This map
     * can be modified without having any effect on the configuration.
     *
     * @return the map
     */
    public abstract Map<String, Object> toMap();

    /**
     * Returns true if this configuration has the same key and value
     * pairs as the other.
     *
     * @param configuration config to compare
     * @return true if similar
     */
    public boolean isSimilar(Configuration configuration) {
        return toMap().equals(configuration.toMap());
    }

    /**
     * Returns the final key in a given path.
     *
     * Example: 'a.b.c' returns 'c'
     *
     * @param path the path
     * @return the final key in the path
     */
    public static String getFinalKey(String path) {
        Preconditions.notNull(path, "path cannot be null");

        String[] parts = path.split(Configuration.PATH_DELIMITER);
        return parts[parts.length - 1]; // last element
    }
}
