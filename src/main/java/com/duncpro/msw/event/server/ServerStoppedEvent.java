package com.duncpro.msw.event.server;

import com.duncpro.msw.event.Event;

/**
 * Called immediately after the server has completely shutdown. Note that that is event is not called after a failed
 * server start.
 */
@Event
public class ServerStoppedEvent {
    private boolean restart;

    /**
     * Constructs a ServerStoppedEvent.
     *
     * @param restart weather or not the server will restart
     */
    public ServerStoppedEvent(boolean restart) {
        this.restart = restart;
    }

    /**
     * Returns true if the server will restart.
     *
     * @return true if the server will start again
     */
    public boolean getRestart() {
        return restart;
    }
}
