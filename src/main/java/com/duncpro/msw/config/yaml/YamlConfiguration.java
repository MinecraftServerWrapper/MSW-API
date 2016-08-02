package com.duncpro.msw.config.yaml;

import com.duncpro.msw.config.Configuration;
import com.duncpro.msw.config.memory.DefaultingMemoryConfiguration;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents a configuration that can be loaded and saved from/to yaml.
 */
public class YamlConfiguration extends DefaultingMemoryConfiguration {
    private static Yaml yaml;

    static {
        DumperOptions options = new DumperOptions();
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        yaml = new Yaml(options);
    }

    /**
     * Loads a yaml configuration.
     *
     * @param inputStream the InputStream.
     */
    public void load(InputStream inputStream) {
        Map<String, Object> contents = (Map<String, Object>) yaml.loadAs(inputStream, HashMap.class);
        getHierarchy().clear();
        getHierarchy().putAll(contents);
    }

    /**
     * Loads a yaml configuration from file.
     *
     * @param file the file.
     * @throws IOException if the file does not exist or an error occurs
     */
    public void load(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        load(fis);
        fis.close();
    }

    /**
     * Saves the configuration.
     *
     * @param outputStream the OutputStream to write to
     * @throws IOException if an error occurs.
     */
    public void save(OutputStream outputStream) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        yaml.dump(toMap(), outputStreamWriter);
        outputStreamWriter.close();
    }

    /**
     * Saves the configuration.
     *
     * @param file the file to save to
     * @throws IOException if an error occurs or the file does not exist.
     */
    public void save(File file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        save(fos);
        fos.close();
    }
}
