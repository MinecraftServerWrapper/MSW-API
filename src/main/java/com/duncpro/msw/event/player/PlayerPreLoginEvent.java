package com.duncpro.msw.event.player;

import com.duncpro.msw.chat.Chat;
import com.duncpro.msw.chat.Message;
import com.duncpro.msw.event.Cancellable;
import com.duncpro.msw.event.Event;
import com.duncpro.msw.net.Client;
import com.duncpro.msw.util.Preconditions;

/**
 * Represents a player about to log in.
 */
@Event
public class PlayerPreLoginEvent extends PlayerEventBase implements Cancellable {
    private boolean cancelled;
    private Message kickMessage;

    public PlayerPreLoginEvent(Client player) {
        super(player);
        kickMessage = Chat.basicMessage("You are not allowed to join this server.");
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    public Message getKickMessage() {
        return kickMessage;
    }

    public void setKickMessage(Message kickMessage) {
        Preconditions.notNull(kickMessage, "kick message cant be null");
        this.kickMessage = kickMessage;
    }
}
