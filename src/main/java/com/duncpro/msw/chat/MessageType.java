package com.duncpro.msw.chat;

/**
 * Types of Minecraft messages.
 */
public enum MessageType {
    /**
     * A chat message sent from another player.
     */
    CHAT,
    /**
     * A chat message sent from the server.
     */
    SYSTEM_MESSAGE,
    /**
     * A message displayed above the hot bar.
     */
    ABOVE_HOT_BAR
}
