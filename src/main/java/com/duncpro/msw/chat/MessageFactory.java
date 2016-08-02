package com.duncpro.msw.chat;

public interface MessageFactory {
    MessageBuilder createMessageBuilder();

    Message fromJson(String json);

    Message combineWithDelimiter(Message delimiter, Message... messages);
}
