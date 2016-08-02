package com.duncpro.msw.net.packet.payload.reader;

import java.io.IOException;
import java.util.UUID;

public interface PayloadReaderBase {
    /**
     * Reads a var int from the packet payload.
     *
     * @return the var int
     * @throws IOException reached end of packet prematurely
     */
    int readVarInt() throws IOException;

    /**
     * Reads a uuid from the packet payload.
     *
     * @return the uuid
     * @throws IOException reached end of packet prematurely
     */
    UUID readUUID() throws IOException;

    /**
     * Reads a string from the packet payload.
     *
     * @return the string
     * @throws IOException reached end of packet prematurely
     */
    String readString() throws IOException;

    byte[] readBytes(int amount);

    void readBytes(byte[] bytes);

    boolean readBoolean();

    short readShort();

    int readInt();

    long readLong();

    float readFloat();

    double readDouble();
}
