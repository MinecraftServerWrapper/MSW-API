package com.duncpro.msw.event;

/**
 * Represents a handler's priority in execution.
 */
public enum HandlerPriority {
    /**
     * Handler is of lowest importance. Other plugins can change the outcome of the event as they see fit.
     * Handler will be executed first.
     */
    LOWEST,
    /**
     * Handler is of low importance.
     * Handler will be executed after all LOWEST handlers are executed.
     */
    LOW,
    /**
     * Handler is of normal importance.
     * Handler will be executed after all LOW and LOWEST handlers are executed.
     */
    NORMAL,
    /**
     * Handler is of high importance.
     * Handler will be executed after all NORMAL, LOW, and LOWEST handlers are executed.
     */
    HIGH,
    /**
     * Handler is of the utmost importance and must have the final say in the outcome of the event.
     * Handler will be executed after all HIGH, NORMAL, LOW, and LOWEST handlers are executed.
     */
    HIGHEST,
    /**
     * Handler is registered purely for the purpose of monitoring the outcome of the event.
     * Handler will be executed after all HIGHEST, HIGH, NORMAL, LOW, and LOWEST handlers are executed.
     * NOTE: Plugins should not change the outcome of the event in MONITOR handlers.
     */
    MONITOR;
}
