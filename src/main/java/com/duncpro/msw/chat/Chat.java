package com.duncpro.msw.chat;

/**
 * Entry point for the MSW Chat API.
 * This class contains various methods involved in creating and manipulating
 * chat related objects.
 */
public class Chat {
    private static MessageFactory factory;

    /**
     * Creates a new {@link MessageBuilder}.
     *
     * @return a new {@link MessageBuilder}.
     */
    public static MessageBuilder newBuilder() {
        return factory.createMessageBuilder();
    }

    /**
     * Creates a new  {@link Message} from the given Mnecraft chat message json.
     *
     * @param json the json
     * @return the new {@link Message}
     */
    public static Message fromJson(String json) {
        return factory.fromJson(json);
    }

    /**
     * Creates a new {@link Message} with no formatting.
     *
     * @param text the text
     * @return the new message with no formatting.
     */
    public static Message basicMessage(String text) {
        return newBuilder().addText(text).build();
    }


    /**
     * Combines multiple messages in to one message.
     *
     * @param messages messages to combineWithDelimiter
     * @return single message
     */
    public static Message combine(Message... messages) {
        return combineWithDelimiter(null, messages);
    }

    /**
     * Combines multiple messages in to one message with a delimiter separating them.
     *
     * @param delimiter the delimiter
     * @param messages the messages
     * @return the combined message
     */
    public static Message combineWithDelimiter(Message delimiter, Message... messages) {
        return factory.combineWithDelimiter(delimiter, messages);
    }

    /**
     * Sets the {@link MessageFactory} that will be used. A default implementation is provided, you may override
     * the default implementation using this method.
     *
     * @param factory the {@link MessageFactory} that will be used.
     */
    public static void setFactory(MessageFactory factory) {
        Chat.factory = factory;
    }
}
