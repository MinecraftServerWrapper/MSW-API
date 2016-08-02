package com.duncpro.msw.chat;

/**
 * Represents a Minecraft chat message.
 */
public interface Message {
    /**
     * Returns the message in plain text.
     *
     * @return the message in plain text.
     */
    String toPlainText();

    /**
     * Returns the message in Minecraft chat format.
     *
     * @return the message in Minecraft chat format.
     */
    String toJson();
}
