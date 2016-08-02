package com.duncpro.msw.event.packet;

import com.duncpro.msw.event.Event;
import com.duncpro.msw.net.Client;
import com.duncpro.msw.net.packet.Packet;

/**
 * Fired when a packet is sent from the client to the server.
 */
@Event
public class UpstreamPacketEvent extends PacketEventBase {
    public UpstreamPacketEvent(Packet packet, Client client) {
        super(packet, client);
    }
}
