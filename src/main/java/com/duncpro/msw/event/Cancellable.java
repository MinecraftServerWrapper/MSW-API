package com.duncpro.msw.event;

public interface Cancellable {
    void setCancelled(boolean cancelled);

    boolean isCancelled();
}
