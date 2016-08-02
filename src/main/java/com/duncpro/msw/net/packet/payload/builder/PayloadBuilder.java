package com.duncpro.msw.net.packet.payload.builder;

import com.duncpro.msw.net.packet.Packet;

import java.util.UUID;

/**
 * Utility for preparing {@link Packet} payloads.
 */
public class PayloadBuilder {
    private static PayloadBuilderBaseFactory factory;

    private PayloadBuilderBase base;

    /**
     * Constructs a PayloadBuilder that uses the global {@link PayloadBuilderBaseFactory} to create
     * its {@link PayloadBuilderBase}.
     */
    public PayloadBuilder() {
        this(factory.createPayloadBuilderBase());
    }

    /**
     * Constructs a PayloadBuilder that uses a custom {@link PayloadBuilderBase}.
     * @param base the base this builder will use to construct payloads
     */
    public PayloadBuilder(PayloadBuilderBase base) {
        this.base = base;
    }

    /**
     * Writes the supplied var int to the packet payload.
     *
     * @param i the var int to write
     * @return this PacketBuilder
     */
    public PayloadBuilder writeVarInt(int i) {
        base.writeVarInt(i);
        return this;
    }

    /**
     * Writes the supplied uuid to the packet payload.
     *
     * @param uuid the uuid to write
     * @return this PacketBuilder
     */
    public PayloadBuilder writeUUID(UUID uuid) {
        base.writeUUID(uuid);
        return this;
    }

    /**
     * Writes the supplied string to the packet payload.
     *
     * @param s the string to write
     * @return this PacketBuilder
     */
    public PayloadBuilder writeString(String s) {
        base.writeString(s);
        return this;
    }

    /**
     * Writes the supplied byte to the packet payload.
     *
     * @param b the byte to write
     * @return this PacketBuilder
     */
    public PayloadBuilder writeByte(byte b) {
        base.writeByte(b);
        return this;
    }

    /**
     * Writes the supplied bytes to the packet payload
     *
     * @param b the bytes to write
     * @return this PacketBuilder
     */
    public PayloadBuilder writeBytes(byte[] b) {
        base.writeBytes(b);
        return this;
    }

    public PayloadBuilder writeBoolean(boolean bool) {
        base.writeBoolean(bool);
        return this;
    }

    public PayloadBuilder writeShort(short s) {
        base.writeShort(s);
        return this;
    }

    public PayloadBuilder writeInt(int i) {
        base.writeInt(i);
        return this;
    }

    public PayloadBuilder writeLong(long l) {
        base.writeLong(l);
        return this;
    }

    public PayloadBuilder writeFloat(float f) {
        base.writeFloat(f);
        return this;
    }

    public PayloadBuilder writeDouble(double d) {
        base.writeDouble(d);
        return this;
    }

    public byte[] build() {
        return base.build();
    }

    /**
     * Sets the {@link PayloadBuilderBaseFactory} to use when constructing new PayloadBuilders. A default implementation is provided, you may override
     * the default implementation using this method.
     *
     * @param factory the factory to use when constructing a new PayloadReader.
     */
    public static void setFactory(PayloadBuilderBaseFactory factory) {
        PayloadBuilder.factory = factory;
    }
}
