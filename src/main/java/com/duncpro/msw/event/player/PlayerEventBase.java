package com.duncpro.msw.event.player;

import com.duncpro.msw.net.Client;

public class PlayerEventBase {
    private Client client;

    public PlayerEventBase(Client client) {
        this.client = client;
    }

    public Client getPlayer() {
        return client;
    }
}
