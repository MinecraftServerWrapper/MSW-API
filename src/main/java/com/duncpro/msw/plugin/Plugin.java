package com.duncpro.msw.plugin;

import com.duncpro.msw.ServerWrapper;
import com.duncpro.msw.command.CommandExecutor;
import com.duncpro.msw.command.plugin.PluginCommandBuilder;
import com.duncpro.msw.config.yaml.YamlConfiguration;
import com.duncpro.msw.config.yaml.YamlFileConfiguration;
import com.duncpro.msw.security.PermissionDocumentation;
import com.duncpro.msw.security.plugin.PluginPermissionRegistry;
import com.duncpro.msw.security.plugin.PluginIdentifiablePermission;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents a plugin that can be loaded on the server wrapper.
 * All plugins should extend this class.
 */
public abstract class Plugin {
    private Logger logger;
    private PluginDescription description;
    private PluginResourceStorage resourceStorage;
    private ServerWrapper serverWrapper;
    private boolean initialized = false;
    private File dataFolder;
    private YamlFileConfiguration config;
    private UUID uuid = UUID.randomUUID();
    private PluginPermissionRegistry permissionRegistry;

    /**
     * Called when the plugin is enabled. All initialization should be handled here. If false is returned
     * the plugin will be marked as not enabled due to failure.
     *
     * @return true if the plugin successfully enabled.
     */
    public abstract boolean enable();

    /**
     * Called when the plugin is disabled. All cleanup should be handled here.
     */
    public abstract void disable();

    public final void initialize(Logger logger, PluginDescription description, PluginResourceStorage resourceStorage,
                                 ServerWrapper serverWrapper, File dataFolder, PluginPermissionRegistry
                                 permissionRegistry) throws IllegalPluginStateException {
        if (initialized) {
            throw new IllegalPluginStateException("Error: " + description.getTitle() + " has already been initialized. It cannot be initialized twice.");
        }

        this.logger = logger;
        this.description = description;
        this.resourceStorage = resourceStorage;
        this.serverWrapper  = serverWrapper;
        this.dataFolder = dataFolder;
        initConfig();
        this.permissionRegistry = permissionRegistry;
        initialized = true;
    }

    private void initConfig() {
        this.config = new YamlFileConfiguration(new File(dataFolder.getPath() + "/config.yml"));

        if (doesResourceExist("default-config.yml")) {
            YamlConfiguration defaults = new YamlConfiguration();
            try {
                InputStream is = getResource("default-config.yml");
                defaults.load(is);
                config.setDefaultConfig(defaults);
                logger.fine("Internally stored default configuration file was automatically loaded by" +
                        " MSW-API.");
            } catch (IOException e) {
                logger.log(Level.SEVERE, "Default configuration file exists in" +
                        " resources but is invalid. Defaults could not be assigned automatically.", e);
            }
        }

        if (config.getFile().exists()) {
            try {
                config.load();
                logger.fine("Existing plugin configuration file was automatically loaded" +
                        " from plugin data folder by MSW-API.");
            } catch (IOException e) {
                getLogger().log(Level.SEVERE, "MSW-API failed to automatically load config.yml", e);
            }
        } else {
            logger.fine("No existing configuration file exists in plugin data folder." +
                    " Nothing for MSW-API to automatically load.");
        }
    }

    /**
     * Returns this plugin's individual logger.
     *
     * @return this plugin's logger.
     */
    public Logger getLogger() {
        return logger;
    }

    /**
     * Returns this plugin's description.
     *
     * @return this plugin's description.
     */
    public PluginDescription getDescription() {
        return description;
    }

    /**
     * The server wrapper this plugin is loaded on.
     *
     * @return The server wrapper the plugin is loaded on.
     */
    public ServerWrapper getServerWrapper() {
        return serverWrapper;
    }

    /**
     * Returns true if the plugin has been initialized. (This is different from enabled.)
     * Initialization just means that the plugin object is prepared and ready to be enabled.
     *
     * @return true if the plugin has been initialized.
     */
    public boolean isInitialized() {
        return initialized;
    }

    /**
     * Returns the configuration file associated with this plugin. Each plugin is assigned a configuration file.
     *
     * @return the configuration file associated with this plugin.
     */
    public YamlFileConfiguration getConfig() {
        return config;
    }

    /**
     * Returns true if the plugin has been enabled.
     *
     * @return true if enabled
     */
    public boolean isEnabled() {
        return serverWrapper.isEnabled(this);
    }

    /**
     * Returns an internal plugin resource.
     *
     * @param name the name of the resource.
     * @return InputStream of file data
     * @throws IOException io error occurs while reading reousrce
     */
    public InputStream getResource(String name) throws IOException {
        return resourceStorage.getResource(name);
    }

    /**
     * Returns true if an internal plugin resource exists.
     *
     * @param name the name of the resource
     * @return true if the resource exists
     */
    public boolean doesResourceExist(String name) {
        return resourceStorage.doesResourceExist(name);
    }

    /**
     * Returns the data folder assigned to this plugin. The plugin data folder can be used to house
     * downloaded resources, libraries, databases, and configurations.
     *
     * @return this plugin's data folder.
     */
    public File getDataFolder() {
        return dataFolder;
    }

    // Ease of use methods

    /**
     * Registers a listener with this plugin as the owner.
     *
     * @param listener the listener
     */
    public void registerListener(Object listener) {
        serverWrapper.registerListener(listener, this);
    }

    /**
     * Registers a {@link com.duncpro.msw.command.plugin.PluginCommand} with this plugin as the owner.
     *
     * @param name the name of the command
     * @param aliases aliases for the name of the command
     * @param executor the executor to use
     */
    public void registerCommand(String name, Set<String> aliases, CommandExecutor executor) {
        getServerWrapper().getCommandRegistry().registerCommand(new PluginCommandBuilder(name, executor, this)
            .withAliases(aliases).build());
    }

    /**
     * Registers a {@link com.duncpro.msw.command.plugin.PluginCommand} with this plugin as the owner.
     *
     * @param name the name of the command
     * @param executor the executor to use
     */
    public void registerCommand(String name, CommandExecutor executor) {
        registerCommand(name, Collections.<String>emptySet(), executor);
    }

    /**
     * Returns the permission with the given name.
     *
     * Keep in mind this only returns permissions registered by the plugin.
     *
     * @throws com.duncpro.msw.security.NonexistentPermissionException if no permission by the given name has been
     * registered.
     * @param name the name of the permission.
     * @return the registered permission
     */
    public PluginIdentifiablePermission getPermission(String name) {
        return permissionRegistry.getPermission(name);
    }

    /**
     * Registers a permission.
     *
     * @throws com.duncpro.msw.security.DuplicatePermissionException if a permission by the given name already exists
     * @param name the name of the permission (cant be null)
     * @param documentation the description of the permission
     * @return the newly registered permission
     */
    public PluginIdentifiablePermission registerPermission(String name, PermissionDocumentation documentation) {
        return permissionRegistry.registerPermission(name, documentation);
    }

    /**
     * Unregisters the permission with the given name.
     *
     * @throws com.duncpro.msw.security.NonexistentPermissionException if no permission by the given name has been
     * registered.
     * @param name the name of the permission
     */
    public void unregisterPermission(String name) {
        permissionRegistry.unregisterPermission(name);
    }

    /**
     * Unregisters the permission.
     *
     * @throws com.duncpro.msw.security.NonexistentPermissionException if no permission by the given name has been
     * registered.
     * @param permission the permission to unregister
     */
    public void unregisterPermission(PluginIdentifiablePermission permission) {
        unregisterPermission(permission.getName());
    }

    /**
     * Returns an unmodifiable set of all registered permissions.
     * If no permissions have been registered an empty set is returned.
     *
     * @return a set of all registered permissions.
     */
    public Set<PluginIdentifiablePermission> getRegisteredPermissions() {
        return permissionRegistry.getRegisteredPermissions();
    }

    // equals & hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Plugin plugin = (Plugin) o;

        return uuid.equals(plugin.uuid);

    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }
}
