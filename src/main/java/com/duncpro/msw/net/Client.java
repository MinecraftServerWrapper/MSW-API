package com.duncpro.msw.net;

import com.duncpro.msw.chat.Message;
import com.duncpro.msw.chat.MessageType;
import com.duncpro.msw.command.CommandSender;
import com.duncpro.msw.net.packet.Packet;
import com.duncpro.msw.security.Permission;

import java.net.InetAddress;
import java.util.Set;
import java.util.UUID;

/**
 * Represents a client that has connected to the wrapper.
 */
public interface Client extends CommandSender {
    /**
     * Returns the client's {@link InetAddress}.
     *
     * @return the client's {@link InetAddress}.
     */
    InetAddress getAddress();

    /**
     * Returns the client's current connection state.
     *
     * @return the client's current connect state.
     */
    ConnectionState getState();

    /**
     * Returns the client's UUID.
     * If the client is not a player
     *
     * @throws ClientNotPlayerException if this client is not a player
     * @return the client's UUID.
     */
    UUID getUUID();

    /**
     * Returns the client's offline UUID.
     *
     * @throws ClientNotPlayerException if this client is not a player
     * @return the client's offline UUID.
     */
    UUID getOfflineUUID();

    /**
     * Returns the client's name.
     *
     * @throws ClientNotPlayerException if this client is not a player
     * @return the client's name.
     */
    String getName();

    /**
     * Returns true if the client is a player.
     *
     * @return true if the client is a player.
     */
    boolean isPlayer();

    /**
     * Disconnects the client from the wrapper with the message "You have been disconnected.".
     */
    void disconnect();

    /**
     * Disconnects the client from the wrapper with the supplied message.
     *
     * @param message the message
     */
    void disconnect(Message message);

    /**
     * Sends the supplied packet to the client.
     * This will not fire {@link com.duncpro.msw.event.packet.DownstreamPacketEvent}
     *
     * @param packet the packet
     */
    void sendPacket(Packet packet);

    /**
     * Sends the supplied packet to the server as if it was coming from this client.
     * This will not fire {@link com.duncpro.msw.event.packet.UpstreamPacketEvent}
     *
     * @param packet the packet
     */
    void receivePacket(Packet packet);

    /**
     * Sends the client a {@link MessageType#SYSTEM_MESSAGE}.
     *
     * @throws ClientNotPlayerException if this client is not a player
     * @param message the message
     */
    @Override
    void sendMessage(Message message);

    /**
     * Sends the client the given message.
     *
     * @throws ClientNotPlayerException if this client is not a player
     * @param message the message
     * @param type the type of message
     */
    void sendMessage(Message message, MessageType type);

    /**
     * Returns all permissions assigned to this player.
     *
     * @throws ClientNotPlayerException if this client is not a player
     * @return all permissions assigned to this PermissionsHolder.
     */
    @Override
    Set<Permission> getPermissions();

    /**
     * Gives the specified {@link Permission} to this player.
     *
     * @throws ClientNotPlayerException if this client is not a player
     * @param permission the specified permission.
     */
    @Override
    void givePermission(Permission permission);

    /**
     * Revoke the specified {@link Permission} from this player.
     *
     * @throws ClientNotPlayerException if this client is not a player
     * @param permission the permission to revoke
     */
    @Override
    void revokePermission(Permission permission);

    /**
     * Returns true if this player has the specified {@link Permission}.
     *
     * @throws ClientNotPlayerException if this client is not a player
     * @param permission the permission to check
     * @return true if player has permission
     */
    @Override
    boolean hasPermission(Permission permission);
}
