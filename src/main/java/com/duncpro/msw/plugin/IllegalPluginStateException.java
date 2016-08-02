package com.duncpro.msw.plugin;

/**
 * Thrown when a {@link Plugin} object is being acted upon but the operation is not possible while the plugin is
 * in its current state.
 */
public class IllegalPluginStateException extends RuntimeException {
    public IllegalPluginStateException(String message) {
        super(message);
    }
}
