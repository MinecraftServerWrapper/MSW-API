package com.duncpro.msw.config.yaml;

import java.io.File;
import java.io.IOException;

/**
 * Represents a file that will store or does store a yaml configuration.
 */
public class YamlFileConfiguration extends YamlConfiguration {
    private File file;

    public YamlFileConfiguration(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public void save() throws IOException {
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
        }
        save(file);
    }

    public void load() throws IOException {
        if (!file.exists()) {
            return;
        }

        load(file);
    }
}
