package com.duncpro.msw.net;

/**
 *  Thrown when a method is invoked an a {@link Client} that assumes (incorrectly) it is
 *  a player.
 */
public class ClientNotPlayerException extends RuntimeException {
    public ClientNotPlayerException(String message) {
        super(message);
    }
}
