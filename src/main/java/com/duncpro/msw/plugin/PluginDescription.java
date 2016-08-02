package com.duncpro.msw.plugin;

import com.duncpro.msw.command.CommandDocumentation;

import java.util.Map;
import java.util.Set;

/**
 * Represents all of a plugin's descriptive information.
 */
public interface PluginDescription {
    /**
     * Returns the name of the plugin.
     *
     * @return the plugin name
     */
    String getName();

    /**
     * Returns the plugin's version identifier.
     *
     * @return the plugin version.
     */
    String getVersion();

    /**
     * Returns a list of the names of the plugins this plugin requires to run properly. This list is unmodifiable.
     * If a plugin has no dependencies, an empty set is returned.
     *
     * @return this plugin's dependencies.
     */
    Set<String> getDependencies();

    /**
     * Returns true if the plugin has at least one dependency.
     *
     * @return true if the plugin has at least one dependency.
     */
    boolean hasDependencies();

    /**
     * Returns a description of the plugin. If this plugin does not provide a description,
     * null is returned.
     *
     * @return A description of the plugin.
     */
    String getDescription();

    /**
     * Returns the following:
     * [Name] v[Version]
     *
     * @return the title
     */
    String getTitle();

    /**
     * Returns true if the plugin has declared that it will not allow the server to run if it is disabled.
     * This is typical of plugins relating to server and world security.
     *
     * @return true if the plugin will not allow the server to run if it is disabled.
     */
    boolean getMustEnable();

    /**
     * Gets all command documentation that was provided in this plugin's description. If no documentation
     * was defined, an empty map is returned. The name of the plugin is the key, and the documentation is the value.
     *
     * @return Plugin description provided command documentation.
     */
    Map<String, CommandDocumentation> getCommandDocumentationMap();
}
