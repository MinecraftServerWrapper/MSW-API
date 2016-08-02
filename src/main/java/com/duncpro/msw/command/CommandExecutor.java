package com.duncpro.msw.command;

public interface CommandExecutor {
    /**
     * Executes a command.
     *
     * @param command the command that is being executed. If an alias is being executed
     *                the command object's name does not change. It is still the same
     *                old command object that was registered.
     * @param sender the sender who sent the command
     * @param args the arguments passed with the command
     */
    void execute(Command command, CommandSender sender, String[] args);
}
