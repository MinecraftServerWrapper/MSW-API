package com.duncpro.msw.net.packet;

/**
 * Created by duncanproctor on 6/10/16.
 */
public class Packet {
    private int id;
    private byte[] payload;

    public Packet(int id, byte[] payload) {
        this.id = id;
        this.payload = payload;
    }

    public int getId() {
        return id;
    }

    public byte[] getPayload() {
        return payload;
    }
}
