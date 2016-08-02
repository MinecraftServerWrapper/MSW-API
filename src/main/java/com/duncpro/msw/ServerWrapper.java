package com.duncpro.msw;

import com.duncpro.msw.chat.Message;
import com.duncpro.msw.command.CommandSender;
import com.duncpro.msw.command.WrapperConsole;
import com.duncpro.msw.command.plugin.CommandRegistry;
import com.duncpro.msw.net.Client;
import com.duncpro.msw.plugin.Plugin;
import com.duncpro.msw.security.Permission;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Level;

/**
 * Represents the server wrapper.
 */
public interface ServerWrapper {
    /**
     * Returns the port the Minecraft server is running on as defined in the wrapper configuration.
     * Players should never connect through this port, they should use the tunnel entrance port instead.
     * Note that this might diff
     *
     * @return the port the Minecraft server is running on
     */
    int getServerPort();

    /**
     * Returns the port that the proxy server should run on.
     * Players should connect to the server using this port and not the server's actual port.
     * By default: 25566
     *
     * @return the port that the proxy server should run on
     */
    int getTunnelEntrancePort();

    /**
     * Returns the name of the directory that plugins will be loaded from.
     * By default: plugins
     *
     * @return the name of the directory that plugins will be loaded from
     */
    String getPluginDirectory();

    /**
     * Returns the name of the server executable as defined in the wrapper configuration.
     * By default: minecraft_server.jar
     *
     * @return the name of the server executable
     */
    String getServerExecutable();

    /**
     * Returns the command line options that the Minecraft server will be started with.
     * The server is started with no options by default. This list is unmodifiable.
     * If no launch options are defined an empty list is returned.
     *
     * @return the command line options that the minecraft server will be started with
     */
    List<String> getServerLaunchOptions();

    /**
     * Returns the options that the JVM will be started with. There are none by
     * default.This list is unmodifiable.
     * If no jvm options are defined an empty list is returned.
     *
     * @return the jvm arguments
     */
    List<String> getJvmOptions();

    /**
     * Returns the directory the world is in (relative to the working directory).
     *
     * @return the world directory
     */
    String getWorldDir();

    /**
     * Returns the String that identifies a chat message as a command.
     * By default: .
     *
     * @return the string that identifies a chat message as a command
     */
    String getCommandPrefix();

    /**
     * Returns the lowest log level that will be logged to the console.
     * By default: INFO
     *
     * @return the lowest log level being logged to the console.
     */
    Level getLowestLogLevel();

    /**
     * Returns a set of all the plugins loaded by the wrapper. These plugins are not necessarily
     * enabled but you can use {@link #isEnabled(Plugin)} to check. This set cant be modified.
     *
     * @return a set of all the plugins loaded by the wrapper
     */
    Set<Plugin> getPlugins();

    /**
     * Returns the plugin loaded on the wrapper by the given name. If a plugin by that name is not loaded on the
     * server null is returned.
     *
     * @param name the name of the plugin
     * @return the plugin
     */
    Plugin getPlugin(String name);

    /**
     * Returns true if the plugin has successfully been enabled.
     *
     * @param plugin the plugin
     * @return true if the plugin is enabled
     */
    boolean isEnabled(Plugin plugin);

    /**
     * Registers a listener. This listener will now be sent events.
     *
     * The owner of the listener is the plugin that is using the listener. Once the owning plugin is
     * disabled, the listener will be automatically removed.
     *
     * @param listener the listener to register
     * @param owner the owner of the listener
     */
    void registerListener(Object listener, Plugin owner);

    /**
     * Removes a listener. This listener will no longer be sent events.
     *
     * @param listener the listener
     */
    void removeListener(Object listener);

    /**
     * Removes all listeners registered by a specific plugin.
     *
     * @param plugin the plugin
     */
    void removeListeners(Plugin plugin);

    /**
     * Sends an event to all registered and capable handlers.
     *
     * @param event the event
     */
    void callEvent(Object event);

    /**
     * Returns a set of all the connected clients. This set is unmodifiable.
     *
     * @return an unmodifiable set of all connected clients
     */
    Set<Client> getConnectedClients();

    /**
     * Returns the client that matches the given name. If no client with that name is connected then null is returned.
     *
     * @param playerName the name of the client
     * @return the client
     */
    Client getPlayer(String playerName);

    /**
     * Returns the client with the given ONLINE UUID. If no client with that uuid is connected then null is returned.
     * It is important to note that this is the UUID that mojang has assigned the player and not the UUID that the
     * server has assigned the player.
     *
     * @param uuid the uuid
     * @return the client
     */
    Client getPlayer(UUID uuid);

    /**
     * Returns the {@link CommandRegistry}.
     *
     * @return the {@link CommandRegistry}.
     */
    CommandRegistry getCommandRegistry();

    /**
     * Returns the version of MSW running.
     *
     * @return the version of MSW
     */
    String getVersion();

    /**
     * Sends the specified command to the server console.
     * IMPORTANT: This has nothing to do with MSW's Command API. This method
     * sends commands directly to the Minecraft server console.
     * There is no need to add a line break to the end of the string, it is appended automatically.
     *
     * @param command the command to send.
     * @throws IllegalStateException if the server has not started.
     */
    void executeServerConsoleCommand(String command);

    /**
     * Executes the given wrapper command as if the specified sender was
     * really the one sending it.
     *
     * @throws com.duncpro.msw.net.ClientNotPlayerException if the supplied sender is a client
     * but not a player.
     * @param command the command to execute
     * @param sender the sender
     */
    void executeWrapperCommand(String command, CommandSender sender);

    /**
     * Returns the {@link CommandSender} that represents the wrapper's console.
     *
     * @return the console sender
     */
    WrapperConsole getConsoleSender();

    /**
     * Gracefully shuts down the server.
     *
     * @throws IllegalStateException if the server is not running yet
     */
    void stopServer();

    /**
     * Gracefully shuts down the server and kicks all connected players.
     *
     * @throws IllegalStateException if the server is not running yet
     * @param message the message to display on the player's 'disconnected from server' screen.
     */
    void stopServer(Message message);

    /**
     * Gracefully shuts down the server and prevents plugin's from restarting it.
     * If an error in your plugin has occurred that poses as a security threat for the entire server
     * then use this instead of {@link #stopServer()}.
     *
     * @throws IllegalStateException if the server is not running yet
     */
    void forciblyStopServer();

    /**
     * Gracefully shuts down the server and prevents plugin's from restarting it.
     * If an error in your plugin has occurred that poses as a security threat for the entire server
     * then use this instead of {@link #stopServer(Message)}.
     *
     * @throws IllegalStateException if the server is not running yet
     * @param message the message to display on the player's 'disconnected from server' screen.
     */
    void forciblyStopServer(Message message);

    /**
     * Gracefully shuts down the server. Once the server has shutdown it is then immediately restarted. This method
     * will still cause {@link com.duncpro.msw.event.server.ServerStoppedEvent} and {@link com.duncpro.msw.event.server.ServerReadyEvent}
     * to be called.
     *
     * @throws IllegalStateException if the server is not running yet
     */
    void restartServer();

    /**
     * Gracefully shuts down the server. Once the server has shutdown it is then immediately restarted. This method
     * will still cause {@link com.duncpro.msw.event.server.ServerStoppedEvent} and {@link com.duncpro.msw.event.server.ServerReadyEvent}
     * to be called.
     *
     * @throws IllegalStateException if the server is not running yet
     * @param message the message to display on the player's 'disconnected from server' screen.
     */
    void restartServer(Message message);

    /**
     * Returns the wrapper permission with the given name.
     *
     * @throws com.duncpro.msw.security.NonexistentPermissionException if a permission by the given name does not
     * exist.
     * @param name the name of the permission to get
     * @return the permission
     */
    Permission getWrapperPermission(String name);

    /**
     * Returns the all wrapper permissions.
     * It is important to realize that has little to nothing to do with plugin registered permissions. This ONLY
     * returns WRAPPER permissions.
     *
     * @return all wrapper permissions.
     */
    Set<Permission> getWrapperPermissions();
}
