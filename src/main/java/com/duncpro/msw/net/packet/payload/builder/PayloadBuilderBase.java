package com.duncpro.msw.net.packet.payload.builder;

import com.duncpro.msw.net.packet.Packet;

import java.util.UUID;

/**
 * Represents an object capable of building {@link Packet} payloads. Each {@link PayloadBuilder} uses its own
 * PayloadBuilderBase to prepare payloads.
 */
public interface PayloadBuilderBase {
    /**
     * Writes the supplied var int to the packet payload.
     *
     * @param i the var int to write
     */
    void writeVarInt(int i);

    /**
     * Writes the supplied uuid to the packet payload.
     *
     * @param uuid the uuid to write
     */
    void writeUUID(UUID uuid);

    /**
     * Writes the supplied string to the packet payload.
     *
     * @param s the string to write
     */
    void writeString(String s);

    /**
     * Writes the supplied byte to the packet payload.
     *
     * @param b the byte to write
     */
    void writeByte(byte b);

    /**
     * writes the supplied bytes to the packet payload
     *
     * @param b the bytes to write
     */
    void writeBytes(byte[] b);

    void writeBoolean(boolean bool);

    void writeShort(short s);

    void writeInt(int i);

    void writeLong(long l);

    void writeFloat(float f);

    void writeDouble(double d);

    /**
     * Builds the packet.
     *
     * @return the packet
     */
    byte[] build();
}
