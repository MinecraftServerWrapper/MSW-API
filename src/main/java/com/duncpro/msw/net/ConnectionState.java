package com.duncpro.msw.net;

/**
 * Minecraft client-server connection states.
 */
public enum ConnectionState {
    /**
     * The client is currently handshaking with the server.
     */
    HANDSHAKING,
    /**
     * The client is currently logging in to the server.
     */
    LOGIN,
    /**
     * The client has logged in and is playing on the server.
     */
    PLAY,
    /**
     * The client is pinging the server for server list information.
     */
    SERVER_LIST_PING
}
