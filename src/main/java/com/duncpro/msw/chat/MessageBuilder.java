package com.duncpro.msw.chat;

/**
 * Utility for creating a {@link Message}.
 */
public interface MessageBuilder {
    /**
     * Adds a line break.
     * Note this does not reset formatting rules (color, bold, etc.)
     *
     * @return this MessageBuilder
     */
    MessageBuilder newLine();

    /**
     * Adds a line break with text after.
     * Note this does not reset formatting rules (color, bold, etc.)
     *
     * @param appendText the text after the line break
     * @return this MessageBuilder
     */
    MessageBuilder newLine(String appendText);

    /**
     * Adds text.
     * Note this does not reset formatting rules (color, bold, etc.)
     * @param text the text to add.
     * @return this MessageBuilder
     */
    MessageBuilder addText(String text);

    /**
     * All text following this method call will be bold unless changed down
     * the line with {@link #bold(boolean)}.
     *
     * @return this MessageBuilder
     */
    MessageBuilder bold();

    /**
     * Sets weather or not the following text will be bold.
     *
     * @param bold true if should be bold
     * @return this MessageBuilder
     */
    MessageBuilder bold(boolean bold);

    /**
     * All text following this method call will be italicized unless changed down
     * the line with {@link #italicize(boolean)}.
     *
     * @return this MessageBuilder
     */
    MessageBuilder italicize();

    /**
     * Sets weather or not the following text will be italicized.
     *
     * @param italicize true if should be bold
     * @return this MessageBuilder
     */
    MessageBuilder italicize(boolean italicize);

    /**
     * All text following this method call will be underlined unless changed down
     * the line with {@link #underline(boolean)}.
     *
     * @return this MessageBuilder
     */
    MessageBuilder underline();

    /**
     * Sets weather or not the following text will be underlined.
     *
     * @param underline true if should be underlined
     * @return this MessageBuilder
     */
    MessageBuilder underline(boolean underline);

    /**
     * All text following this method call will be the supplied color unless changed down
     * the line with {@link #color(ChatColor)}.
     *
     * @param chatColor the chat color
     * @return this MessageBuilder
     */
    MessageBuilder color(ChatColor chatColor);

    /**
     * Creates a {@link Message} from the supplied text and formatting information.
     *
     * @return a new {@link Message}.
     */
    Message build();
}
