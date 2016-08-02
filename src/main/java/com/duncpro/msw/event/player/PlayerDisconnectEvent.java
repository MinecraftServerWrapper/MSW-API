package com.duncpro.msw.event.player;

import com.duncpro.msw.event.Event;
import com.duncpro.msw.net.Client;

/**
 * Fired when a player is kicked or willfully disconnect from the wrapper.
 */
@Event
public class PlayerDisconnectEvent extends PlayerEventBase {
    public PlayerDisconnectEvent(Client client) {
        super(client);
    }
}
