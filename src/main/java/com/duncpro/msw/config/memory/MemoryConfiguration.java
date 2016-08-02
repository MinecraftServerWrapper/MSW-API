package com.duncpro.msw.config.memory;

import com.duncpro.msw.config.Configuration;
import com.duncpro.msw.config.ConfigurationSection;
import com.duncpro.msw.config.exception.NonexistentKeyException;
import com.duncpro.msw.util.Preconditions;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * An implementation for {@link Configuration} that stores keys and values
 * in a HashMap.
 */
public class MemoryConfiguration extends Configuration {
    private Map<String, Object> hierarchy;

    public MemoryConfiguration() {
        this.hierarchy = new HashMap<>();
    }

    /**
     * Creates a new MemoryConfiguration with the contents of the provided configuration.
     *
     * @param config the config to clone
     */
    public MemoryConfiguration(Configuration config) {
        Preconditions.notNull(config, "config cant be null");
        hierarchy = deepCopy(config.toMap());
    }

    @Override
    public Set<String> getKeys(String path) {
        Preconditions.notNull(path, "Path cannot be null.");
        // Append to end of path because getParentMapSection() returns the parent map section
        // of the path, not the actual map at the path.
        if (!doesValueExistAt(path)) {
            throw new NonexistentKeyException("No key was found while traversing path: '" + path + "'.");
        }
        Object value;
        if (!((value = getParentMapSection(path).get(getFinalKey(path))) instanceof Map)) {
            throw new IllegalArgumentException("A value exists at '" + path + "' and is not a container.");
        }
        return ((Map<String, Object>) value).keySet();
    }

    @Override
    public Set<String> getKeys() {
        return hierarchy.keySet();
    }

    @Override
    public boolean doesValueExistAt(String path) {
        Preconditions.notNull(path, "Path cannot be null.");

        String finalKey = getFinalKey(path);
        Map<String, Object> parentMapSection = getParentMapSection(path);
        if (parentMapSection == null) {
            return false;
        } else {
            return parentMapSection.containsKey(finalKey);
        }
    }

    @Override
    public ConfigurationSection getSection(String path) {
        Preconditions.notNull(path, "Path cannot be null.");

        getParentMapSection(path); // This method checks if a map does indeed exist at the given path
                                   // It will throw a IllegalArgumentException if a map does not exist
                                   // at the path.


        return new ConfigurationSection(this, path);
    }

    @Override
    public void set(String path, Object value) {
        Preconditions.notNull(path, "Path cannot be null.");

        String finalKey = getFinalKey(path);
        String[] pathParts = path.split(PATH_DELIMITER);

        Map<String, Object> mapSection = hierarchy;
        for (int i = 0; i < pathParts.length - 1; i++) { // Omit last part, we are returning the parent section, not the actual value
            String part = pathParts[i];
            Object mapValue = mapSection.get(part);
            if (mapValue == null || (mapValue != null && !(mapValue instanceof HashMap))) {
                mapSection.put(part, mapValue = new HashMap<>());

            }
            mapSection = (Map<String, Object>) mapValue;
        }

        mapSection.put(finalKey, value);
    }

    @Override
    public void delete(String path) {
        if (!doesValueExistAt(path)) {
            throw new NonexistentKeyException("No key was found while traversing path: '" + path + "'.");
        }
        getParentMapSection(path).remove(getFinalKey(path));
    }

    @Override
    public Object retrieveValue(String path) {
        Preconditions.notNull(path, "Path cannot be null.");

        String finalKey = getFinalKey(path);
        String[] pathParts = path.split(PATH_DELIMITER);

        if (pathParts.length == 1) {
            return hierarchy.get(path);
        }

        Map<String, Object> parentMapSection = getParentMapSection(path);
        if (parentMapSection == null) {
            throw new NonexistentKeyException("No key was found while traversing path: '" + path + "'.");
        }

        Object value = parentMapSection.get(finalKey);
        if (value instanceof Map) {
            return new ConfigurationSection(this, path);
        } else {
            return value;
        }
    }

    @Override
    public Map<String, Object> toMap() {
        return deepCopy(hierarchy); // Well this is easy:)
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MemoryConfiguration that = (MemoryConfiguration) o;

        return hierarchy.equals(that.hierarchy);

    }

    @Override
    public int hashCode() {
        return hierarchy.hashCode();
    }


    private Map<String, Object> getParentMapSection(String path) {
        String[] pathParts = path.split(PATH_DELIMITER);

        Map<String, Object> mapSection = hierarchy;
        for (int i = 0; i < pathParts.length - 1; i++) { // Omit last part, we are returning the parent section, not the actual value
            String part = pathParts[i];
            Object mapValue = mapSection.get(part);
            if (mapValue == null) {
                return null;
            } else if (!(mapValue instanceof HashMap)) {
                throw new IllegalArgumentException("A value exists at '" + path + "' and is not a container.");
            }
            mapSection = (Map<String, Object>) mapValue;
        }
        return mapSection;
    }

    /**
     * Exposes the underlying Map used by the MemoryConfiguration.
     *
     * @return the underlying Map used by the MemoryConfiguration
     */
    protected Map<String, Object> getHierarchy() {
        return hierarchy;
    }


    private static Map deepCopy(Map original) {
        Map copy = new HashMap();

        for (Object keyObject : original.keySet()) {
            String key = (String) keyObject;
            Object value = original.get(key);

            if (value instanceof Map) {
                copy.put(key, deepCopy((HashMap) value));
            } else {
                copy.put(key, value);
            }
        }

        return copy;
    }
}
