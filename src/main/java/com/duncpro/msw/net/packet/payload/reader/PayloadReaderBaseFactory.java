package com.duncpro.msw.net.packet.payload.reader;

public interface PayloadReaderBaseFactory {
    PayloadReaderBase createPayloadReaderBase(byte[] payload);
}
