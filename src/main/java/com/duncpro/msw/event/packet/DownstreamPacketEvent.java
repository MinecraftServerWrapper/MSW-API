package com.duncpro.msw.event.packet;

import com.duncpro.msw.event.Event;
import com.duncpro.msw.net.Client;
import com.duncpro.msw.net.packet.Packet;

/**
 * Fired when a packet is sent from the server to the client.
 */
@Event
public class DownstreamPacketEvent extends PacketEventBase {
    public DownstreamPacketEvent(Packet packet, Client client) {
        super(packet, client);
    }
}
