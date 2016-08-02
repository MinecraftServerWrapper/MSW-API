package com.duncpro.msw.net.packet.payload.reader;

import com.duncpro.msw.net.packet.Packet;

import java.io.IOException;
import java.util.UUID;

/**
 * Utility for reading {@link Packet} payloads. This class provides various methods for reading the contents of a packet
 * payload. It functions similarly to an {@link java.io.InputStream}.
 */
public class PayloadReader {
    private static PayloadReaderBaseFactory factory;

    private PayloadReaderBase base;

    /**
     * Constructs a PayloadReader.
     *
     * This reader will use the global {@link com.duncpro.msw.net.packet.payload.builder.PayloadBuilderBaseFactory}
     * to generate its {@link PayloadReaderBase}.
     * @param payload the payload to read
     */
    public PayloadReader(byte[] payload) {
        base = factory.createPayloadReaderBase(payload);
    }

    /**
     * Extracts the payload from a {@link Packet} and constructs a {@link PayloadReader}.
     * This is an ease of use method, in fact, it is the exact same as "new PayloadReader(packet.getPayload());".
     *
     * This reader will use the global {@link com.duncpro.msw.net.packet.payload.builder.PayloadBuilderBaseFactory}
     * to generate its {@link PayloadReaderBase}.
     * @param packet the packet whose payload will be read
     */
    public PayloadReader(Packet packet) {
        this(packet.getPayload());
    }

    /**
     * Constructs a PayloadReader with the supplied {@link PayloadReaderBase}.
     * @param base the {@link PayloadReaderBase} to use.
     */
    public PayloadReader(PayloadReaderBase base) {
        this.base = base;
    }

    /**
     * Reads a var int from the packet payload.
     *
     * @return the var int
     * @throws IOException reached end of packet prematurely
     */
    public int readVarInt() throws IOException {
        return base.readVarInt();
    }

    /**
     * Reads a uuid from the packet payload.
     *
     * @return the uuid
     * @throws IOException reached end of packet prematurely
     */
    public UUID readUUID() throws IOException {
        return base.readUUID();
    }

    /**
     * Reads a string from the packet payload.
     *
     * @return the string
     * @throws IOException reached end of packet prematurely
     */
    public String readString() throws IOException {
        return base.readString();
    }

    public byte[] readBytes(int amount) {
        return base.readBytes(amount);
    }

    public void readBytes(byte[] bytes) {
        base.readBytes(bytes);
    }

    public boolean readBoolean() {
        return base.readBoolean();
    }

    public short readShort() {
        return base.readShort();
    }

    public int readInt() {
        return base.readInt();
    }

    public long readLong() {
        return base.readLong();
    }

    public float readFloat() {
        return base.readFloat();
    }

    public double readDouble() {
        return base.readDouble();
    }

    /**
     * Sets the {@link PayloadReaderBaseFactory} to use when constructing new PayloadReaders. A default implementation is provided, you may override
     * the default implementation using this method.
     *
     * @param factory the factory to use when constructing a new PayloadReader.
     */
    public static void setFactory(PayloadReaderBaseFactory factory) {
        PayloadReader.factory = factory;
    }
}
