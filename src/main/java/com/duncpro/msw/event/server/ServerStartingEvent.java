package com.duncpro.msw.event.server;

import com.duncpro.msw.event.Event;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Fired immediately before MSW starts the server
 */
@Event
public class ServerStartingEvent {
    private List<String> serverLaunchOptions;
    private List<String> jvmOptions;

    public ServerStartingEvent(List<String> serverLaunchOptions, List<String> jvmOptions) {
        this.serverLaunchOptions = serverLaunchOptions;
        this.jvmOptions = jvmOptions;
    }

    public List<String> getServerLaunchOptions() {
        return Collections.unmodifiableList(serverLaunchOptions);
    }

    public void addServerLaunchOption(String arg) {
        serverLaunchOptions.add(arg);
    }

    public void removeServerLaunchOption(String arg) {
        serverLaunchOptions.remove(arg);
    }

    public List<String> getJvmOptions() {
        return Collections.unmodifiableList(jvmOptions);
    }

    public void addJvmOption(String arg) {
        jvmOptions.add(arg);
    }

    public void removeJvmOption(String arg) {
        jvmOptions.remove(arg);
    }
}
