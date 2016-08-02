package com.duncpro.msw.config.memory;

import com.duncpro.msw.config.Configuration;
import com.duncpro.msw.config.exception.NonexistentKeyException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * An implementation of {@link Configuration} that stores keys and values in a {@link MemoryConfiguration}.
 * This implementation also provides a method for setting default values that are used if no
 * value exists.
 */
public class DefaultingMemoryConfiguration extends MemoryConfiguration {
    private Configuration defaultConfig;
    private boolean allowNullValues;

    /**
     * Clones a DefaultingMemoryConfiguration
     *
     * @param config the config to clone
     */
    public DefaultingMemoryConfiguration(DefaultingMemoryConfiguration config) {
        super(config);
        if (config.defaultConfig != null) {
            defaultConfig = new MemoryConfiguration(config.defaultConfig);
        }
        allowNullValues = config.allowNullValues;
    }

    /**
     * Creates a DefaultingMemoryConfiguration that does not allow null values
     * and has no default values.
     */
    public DefaultingMemoryConfiguration() {
        this(false);
    }

    /**
     * Creates a DefaultingMemoryConfiguration that might allow null values
     * and has no default values.
     *
     * @param allowNullValues If false, null values will not be accepted. Note that null values
     *                        can still exist in the default configuration and will be carried over.
     */
    public DefaultingMemoryConfiguration(boolean allowNullValues) {
        this.allowNullValues = allowNullValues;
    }

    /**
     * Creates a DefaultingMemoryConfiguration.
     *
     * Note that default values are always allowed in the default configuration.
     *
     * @param defaultConfig default values
     * @param allowNullValues should allow null values
     */
    public DefaultingMemoryConfiguration(Configuration defaultConfig, boolean allowNullValues) {
        this.allowNullValues = allowNullValues;
        this.defaultConfig = defaultConfig;
    }

    @Override
    public Set<String> getKeys(String path) {
        Set<String> keys;
        try {
            keys = super.getKeys(path);
        } catch (NonexistentKeyException e) {
            if (defaultConfig != null) {
                return defaultConfig.getKeys(path);
            } else {
                throw new NonexistentKeyException("No key was found while traversing path: '" + path + "' in either the configuration" +
                        " or in the default configuration.");
            }
        }
        // If we are here then a value for keys was found
        return keys;
    }

    @Override
    public Set<String> getKeys() {
        Set<String> keys = super.getKeys();
        if (keys.isEmpty() && !allowNullValues && defaultConfig != null) {
            keys = defaultConfig.getKeys();
        }
        return keys;
    }

    @Override
    public boolean doesValueExistAt(String path) {
        // Preconditions.notNull(path, "path cannot be null"); already done for us by MemoryConfiguration, trust me
        boolean result = super.doesValueExistAt(path);

        // If the value is set to null, and null is disallowed, then its like no value is there in the first place.
        // Using super.retrieveValue() because we want to see if the value is really null, not get the default value
        // if it is null.
        if (result && super.retrieveValue(path) == null && !allowNullValues) {
            return false;
        }

        return result;
    }

    @Override
    public void set(String path, Object value) {
        if (value == null && !allowNullValues) {
            throw new IllegalArgumentException("Value cannot be null because allowNullValues is false.");
        }

        super.set(path, value);
    }

    /**
     * Retrieves the value located at the given path.
     *
     * This should be implemented by the configuration type.
     *
     * To avoid {@link NonexistentKeyException} use {@link #doesValueExistAt(String)}
     * @throws NonexistentKeyException if the given key does not exist in the configuration or default configuration
     * @param path the relative path of the value
     * @return the value stored at the supplied path
     */
    @Override
    public Object retrieveValue(String path) {
        // Preconditions.notNull(path, "path cannot be null"); already done for us by MemoryConfiguration, trust me

        if (super.doesValueExistAt(path) && super.retrieveValue(path) != null) { // cant use super.isValueNull() or else looping method structure
            return super.retrieveValue(path);
        } else if (defaultConfig != null && defaultConfig.doesValueExistAt(path)) {
            return defaultConfig.retrieveValue(path);
        } else {
            throw new NonexistentKeyException("No key was found while traversing path: '" + path + "' in either the configuration" +
                    " or in the default configuration.");
        }
    }

    @Override
    public Map<String, Object> toMap() {
        if (getDefaultConfig() != null) {
            return deepMerge(getDefaultConfig().toMap(), super.toMap(), allowNullValues);
        } else {
            return super.toMap();
        }
    }

    /**
     * Checks if a value exists in the default configuration.
     *
     * @param path the path
     * @return true if a value exists
     */
    public boolean doesDefaultValueExistAt(String path) {
        // Preconditions.notNull(path, "path cannot be null"); already done for us by MemoryConfiguration, trust me

        if (defaultConfig == null) {
            return false;
        } else {
            return defaultConfig.doesValueExistAt(path);
        }
    }

    /**
     * Sets a path to its default value.
     *
     * @throws IllegalStateException If no default value has been set for the path.
     * @param path the path to set
     */
    public void restoreDefault(String path) {
        // Preconditions.notNull(path, "path cannot be null"); already done for us by MemoryConfiguration, trust me

        if (defaultConfig == null) {
            throw new IllegalStateException("No default configuration has been set!");
        }

        if (!defaultConfig.doesValueExistAt(path)) {
            throw new IllegalStateException("No default value has been set for " + path);
        }

        delete(path); // The default value should be used from now on
    }

    /**
     * Returns the default configuration. If no default configuration has been set then null is returned.
     *
     * @return the default configuration
     */
    public Configuration getDefaultConfig() {
        return defaultConfig;
    }

    /**
     * Sets the default configuration.
     *
     * @param defaultConfig the default configuration
     */
    public void setDefaultConfig(Configuration defaultConfig) {
        this.defaultConfig = defaultConfig;
    }

    /**
     * Returns true if one DefaultingMemoryConfiguration is configured exactly
     * the same as the other and .toMap() on each object returns the same result.
     *
     * @param o the config to compare
     * @return true if one DefaultingMemoryConfiguration is equal to another
     */
    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        DefaultingMemoryConfiguration that = (DefaultingMemoryConfiguration) o;

        if (allowNullValues != that.allowNullValues) return false;
        return (that.toMap().equals(this.toMap()));

    }


    private static Map deepMerge(Map under, Map over, boolean allowNullOverValues) {
        under = new HashMap(under);
        for (Object key : over.keySet()) {
            if (over.get(key) instanceof Map && under.get(key) instanceof Map) {
                Map originalChild = (Map) under.get(key);
                Map newChild = (Map) over.get(key);
                under.put(key, deepMerge(originalChild, newChild, allowNullOverValues));
            } else {
                Object value = over.get(key);
                if (!(value == null && !allowNullOverValues)) {
                    under.put(key, value);
                }
            }
        }
        return under;
    }
}
