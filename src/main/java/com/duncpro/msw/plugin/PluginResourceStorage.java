package com.duncpro.msw.plugin;

import java.io.IOException;
import java.io.InputStream;

public interface PluginResourceStorage {
    InputStream getResource(String name) throws IOException;

    boolean doesResourceExist(String name);
}
