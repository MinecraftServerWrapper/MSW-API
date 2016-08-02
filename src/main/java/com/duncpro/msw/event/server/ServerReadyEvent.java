package com.duncpro.msw.event.server;

import com.duncpro.msw.event.Event;

/**
 * Fired when the server starts accepting client connections. It should now be safe to execute server console
 * commands.
 */
@Event
public class ServerReadyEvent {
}
