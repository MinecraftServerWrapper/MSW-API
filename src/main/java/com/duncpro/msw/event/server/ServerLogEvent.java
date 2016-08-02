package com.duncpro.msw.event.server;

import com.duncpro.msw.event.Event;

/**
 * Fired when the server outputs a line of text to the console.
 * Note this is not fired when MSW logs text.
 */
@Event
public class ServerLogEvent {
    private String message;

    public ServerLogEvent(String message) {
        this.message = message;
    }

    /**
     * The line of text that was logged.
     * @return the text
     */
    public String getMessage() {
        return message;
    }
}
