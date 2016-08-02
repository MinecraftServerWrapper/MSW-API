package com.duncpro.msw.command;

import com.duncpro.msw.chat.Message;
import com.duncpro.msw.security.PermissionHolder;

/**
 * Represents a class capable of sending commands.
 */
public interface CommandSender extends PermissionHolder {
    /**
     * Sends a message to the command sender.
     *
     * @param message the message
     */
    void sendMessage(Message message);
}
