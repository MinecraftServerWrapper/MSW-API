package com.duncpro.msw.event.packet;

import com.duncpro.msw.event.Cancellable;
import com.duncpro.msw.net.Client;
import com.duncpro.msw.net.packet.Packet;
import com.duncpro.msw.util.Preconditions;

public class PacketEventBase implements Cancellable {
    private Packet packet;
    private Client client;
    private boolean cancelled;

    public PacketEventBase(Packet packet, Client client) {
        this.packet = packet;
        this.client = client;
    }

    /**
     * Returns the packet to be transmitted
     * @return the packet to be transmitted
     */
    public Packet getPacket() {
        return packet;
    }

    /**
     * Changes the packet that is being transmitted to the one provided.
     * @param packet the packet
     */
    public void setPacket(Packet packet) {
        Preconditions.notNull(packet, "packet cant be null. Use setCancelled(true) instead.");
        this.packet = packet;
    }

    /**
     * Returns the client involved in the transmission
     * @return the client involved in the transmission
     */
    public Client getClient() {
        return client;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }
}
