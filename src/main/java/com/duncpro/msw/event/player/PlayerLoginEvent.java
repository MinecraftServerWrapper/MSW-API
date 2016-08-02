package com.duncpro.msw.event.player;

import com.duncpro.msw.event.Event;
import com.duncpro.msw.net.Client;

/**
 * Fired when a player connects to the wrapper. This event cannot be cancelled but
 * {@link PlayerPreLoginEvent} can.
 */
@Event
public class PlayerLoginEvent extends PlayerEventBase {
    public PlayerLoginEvent(Client client) {
        super(client);
    }
}
