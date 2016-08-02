package com.duncpro.msw.config;

import java.util.Set;

/**
 * A section of a {@link Configuration}.
 *
 * Note that ConfigurationSections can become invalid if the key where they reside is
 * assigned to a new value. Also note that all path parameters in this class are 'relative' to
 * the section's base path.
 */
public class ConfigurationSection extends Configurable {
    private Configuration root;
    private String path;

    /**
     * Constructs a ConfigurationSection.
     *
     * @param root the root
     * @param path the path
     */
    public ConfigurationSection(Configuration root, String path) {
        this.root = root;
        this.path = path;
    }

    /**
     * Returns the root {@link Configuration} object for this ConfigurationSection.
     *
     * @return the root {@link Configuration}
     */
    public Configuration getRoot() {
        return root;
    }

    /**
     * Returns this configuration section's base path. This is the path
     * that is prepended to all relative paths.
     *
     * @return the configuration section's base path.
     */
    public String getPath() {
        return path;
    }

    /**
     * Returns true if this configuration section currently exists.
     *
     * @return true if the configuration section exists
     */
    public boolean exists() {
        return root.doesValueExistAt(path);
    }

    @Override
    public Set<String> getKeys(String path) {
        return root.getKeys(buildFullPath(path));
    }

    @Override
    public Set<String> getKeys() {
        return root.getKeys(path);
    }

    @Override
    public boolean doesValueExistAt(String path) {
        return root.doesValueExistAt(buildFullPath(path));
    }

    @Override
    public ConfigurationSection getSection(String path) {
        return root.getSection(buildFullPath(path));
    }

    @Override
    public void set(String path, Object value) {
        root.set(buildFullPath(path), value);
    }

    @Override
    public void delete(String path) {
        root.delete(buildFullPath(path));
    }

    @Override
    public Object retrieveValue(String path) {
        return root.retrieveValue(buildFullPath(path));
    }

    private String buildFullPath(String relativePath) {
        if (this.path == null) {
            return relativePath;
        } else {
            return this.path + "." + relativePath;
        }
    }
}
