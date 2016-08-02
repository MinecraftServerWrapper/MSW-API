package com.duncpro.msw.config;

import com.duncpro.msw.config.exception.NonexistentKeyException;

import java.util.List;
import java.util.Set;

/**
 * Base for configuration classes.
 */
public abstract class Configurable {
    /**
     * Returns the value at the given path. If the value at the path is not a byte
     * a {@link ClassCastException} is thrown.
     *
     * If the key exists but the value has been set to null, then null is returned.
     * Note that some implementations prevent null values.
     *
     * @param path the path where the value resides
     * @throws NonexistentKeyException If no key exists at the path provided.
     * @throws ClassCastException If the value is not of the correct type.
     * @throws IllegalArgumentException If null is supplied for the path
     * @return the value at the path
     */
    public Byte getByte(String path) {
        return (Byte) retrieveValue(path);
    }

    /**
     * Returns the value at the given path. If the value at the path is not a byte list
     * a {@link ClassCastException} is thrown.
     *
     * If the key exists but the value has been set to null, then null is returned.
     * Note that some implementations prevent null values.
     *
     * @param path the path where the value resides
     * @throws NonexistentKeyException If no key exists at the path provided.
     * @throws ClassCastException If the value is not of the correct type.
     * @throws IllegalArgumentException If null is supplied for the path
     * @return the value at the path
     */
    public List<Byte> getByteList(String path) {
        return (List<Byte>) retrieveValue(path);
    }

    /**
     * Returns the value at the given path. If the value at the path is not a short
     * a {@link ClassCastException} is thrown.
     *
     * If the key exists but the value has been set to null, then null is returned.
     * Note that some implementations prevent null values.
     *
     * @param path the path where the value resides
     * @throws NonexistentKeyException If no key exists at the path provided.
     * @throws ClassCastException If the value is not of the correct type.
     * @throws IllegalArgumentException If null is supplied for the path
     * @return the value at the path
     */
    public Short getShort(String path) {
        return (Short) retrieveValue(path);
    }

    /**
     * Returns the value at the given path. If the value at the path is not a short list
     * a {@link ClassCastException} is thrown.
     *
     * If the key exists but the value has been set to null, then null is returned.
     * Note that some implementations prevent null values.
     *
     * @param path the path where the value resides
     * @throws NonexistentKeyException If no key exists at the path provided.
     * @throws ClassCastException If the value is not of the correct type.
     * @throws IllegalArgumentException If null is supplied for the path
     * @return the value at the path
     */
    public List<Short> getShortList(String path) {
        return (List<Short>) retrieveValue(path);
    }

    /**
     * Returns the value at the given path. If the value at the path is not a int
     * a {@link ClassCastException} is thrown.
     *
     * If the key exists but the value has been set to null, then null is returned.
     * Note that some implementations prevent null values.
     *
     * @param path the path where the value resides
     * @throws NonexistentKeyException If no key exists at the path provided.
     * @throws ClassCastException If the value is not of the correct type.
     * @throws IllegalArgumentException If null is supplied for the path
     * @return the value at the path
     */
    public Integer getInt(String path) {
        return (Integer) retrieveValue(path);
    }

    /**
     * Returns the value at the given path. If the value at the path is not a int list
     * a {@link ClassCastException} is thrown.
     *
     * If the key exists but the value has been set to null, then null is returned.
     * Note that some implementations prevent null values.
     *
     * @param path the path where the value resides
     * @throws NonexistentKeyException If no key exists at the path provided.
     * @throws ClassCastException If the value is not of the correct type.
     * @throws IllegalArgumentException If null is supplied for the path
     * @return the value at the path
     */
    public List<Integer> getIntList(String path) {
        return (List<Integer>) retrieveValue(path);
    }

    /**
     * Returns the value at the given path. If the value at the path is not a long
     * a {@link ClassCastException} is thrown.
     *
     * If the key exists but the value has been set to null, then null is returned.
     * Note that some implementations prevent null values.
     *
     * @param path the path where the value resides
     * @throws NonexistentKeyException If no key exists at the path provided.
     * @throws ClassCastException If the value is not of the correct type.
     * @throws IllegalArgumentException If null is supplied for the path
     * @return the value at the path
     */
    public Long getLong(String path) {
        return (Long) retrieveValue(path);
    }

    /**
     * Returns the value at the given path. If the value at the path is not a long list
     * a {@link ClassCastException} is thrown.
     *
     * If the key exists but the value has been set to null, then null is returned.
     * Note that some implementations prevent null values.
     *
     * @param path the path where the value resides
     * @throws NonexistentKeyException If no key exists at the path provided.
     * @throws ClassCastException If the value is not of the correct type.
     * @throws IllegalArgumentException If null is supplied for the path
     * @return the value at the path
     */
    public List<Long> getLongList(String path) {
        return (List<Long>) retrieveValue(path);
    }

    /**
     * Returns the value at the given path. If the value at the path is not a float
     * a {@link ClassCastException} is thrown.
     *
     * If the key exists but the value has been set to null, then null is returned.
     * Note that some implementations prevent null values.
     *
     * @param path the path where the value resides
     * @throws NonexistentKeyException If no key exists at the path provided.
     * @throws ClassCastException If the value is not of the correct type.
     * @throws IllegalArgumentException If null is supplied for the path
     * @return the value at the path
     */
    public Float getFloat(String path) {
        return (Float) retrieveValue(path);
    }

    /**
     * Returns the value at the given path. If the value at the path is not a float list
     * a {@link ClassCastException} is thrown.
     *
     * If the key exists but the value has been set to null, then null is returned.
     * Note that some implementations prevent null values.
     *
     * @param path the path where the value resides
     * @throws NonexistentKeyException If no key exists at the path provided.
     * @throws ClassCastException If the value is not of the correct type.
     * @throws IllegalArgumentException If null is supplied for the path
     * @return the value at the path
     */
    public List<Float> getFloatList(String path) {
        return (List<Float>) retrieveValue(path);
    }

    /**
     * Returns the value at the given path. If the value at the path is not a double
     * a {@link ClassCastException} is thrown.
     *
     * If the key exists but the value has been set to null, then null is returned.
     * Note that some implementations prevent null values.
     *
     * @param path the path where the value resides
     * @throws NonexistentKeyException If no key exists at the path provided.
     * @throws ClassCastException If the value is not of the correct type.
     * @throws IllegalArgumentException If null is supplied for the path
     * @return the value at the path
     */
    public Double getDouble(String path) {
        return (Double) retrieveValue(path);
    }

    /**
     * Returns the value at the given path. If the value at the path is not a double list
     * a {@link ClassCastException} is thrown.
     *
     * If the key exists but the value has been set to null, then null is returned.
     * Note that some implementations prevent null values.
     *
     * @param path the path where the value resides
     * @throws NonexistentKeyException If no key exists at the path provided.
     * @throws ClassCastException If the value is not of the correct type.
     * @throws IllegalArgumentException If null is supplied for the path
     * @return the value at the path
     */
    public List<Double> getDoubleList(String path) {
        return (List<Double>) retrieveValue(path);
    }

    /**
     * Returns the value at the given path. If the value at the path is not a boolean
     * a {@link ClassCastException} is thrown.
     *
     * If the key exists but the value has been set to null, then null is returned.
     * Note that some implementations prevent null values.
     *
     * @param path the path where the value resides
     * @throws NonexistentKeyException If no key exists at the path provided.
     * @throws ClassCastException If the value is not of the correct type.
     * @throws IllegalArgumentException If null is supplied for the path
     * @return the value at the path
     */
    public Boolean getBoolean(String path) {
        return (Boolean) retrieveValue(path);
    }

    /**
     * Returns the value at the given path. If the value at the path is not a boolean list
     * a {@link ClassCastException} is thrown.
     *
     * If the key exists but the value has been set to null, then null is returned.
     * Note that some implementations prevent null values.
     *
     * @param path the path where the value resides
     * @throws NonexistentKeyException If no key exists at the path provided.
     * @throws ClassCastException If the value is not of the correct type.
     * @throws IllegalArgumentException If null is supplied for the path
     * @return the value at the path
     */
    public List<Boolean> getBooleanList(String path) {
        return (List<Boolean>) retrieveValue(path);
    }

    /**
     * Returns the value at the given path. If the value at the path is not a char
     * a {@link ClassCastException} is thrown.
     *
     * If the key exists but the value has been set to null, then null is returned.
     * Note that some implementations prevent null values.
     *
     * @param path the path where the value resides
     * @throws NonexistentKeyException If no key exists at the path provided.
     * @throws ClassCastException If the value is not of the correct type.
     * @throws IllegalArgumentException If null is supplied for the path
     * @return the value at the path
     */
    public Character getChar(String path) {
        return (Character) retrieveValue(path);
    }

    /**
     * Returns the value at the given path. If the value at the path is not a char list
     * a {@link ClassCastException} is thrown.
     *
     * If the key exists but the value has been set to null, then null is returned.
     * Note that some implementations prevent null values.
     *
     * @param path the path where the value resides
     * @throws NonexistentKeyException If no key exists at the path provided.
     * @throws ClassCastException If the value is not of the correct type.
     * @throws IllegalArgumentException If null is supplied for the path
     * @return the value at the path
     */
    public List<Character> getCharList(String path) {
        return (List<Character>) retrieveValue(path);
    }

    /**
     * Returns the value at the given path. If the value at the path is not a string
     * a {@link ClassCastException} is thrown.
     *
     * If the key exists but the value has been set to null, then null is returned.
     * Note that some implementations prevent null values.
     *
     * @param path the path where the value resides
     * @throws NonexistentKeyException If no key exists at the path provided.
     * @throws ClassCastException If the value is not of the correct type.
     * @throws IllegalArgumentException If null is supplied for the path
     * @return the value at the path
     */
    public String getString(String path) {
        return (String) retrieveValue(path);
    }

    /**
     * Returns the value at the given path. If the value at the path is not a string list
     * a {@link ClassCastException} is thrown.
     *
     * If the key exists but the value has been set to null, then null is returned.
     * Note that some implementations prevent null values.
     *
     * @param path the path where the value resides
     * @throws NonexistentKeyException If no key exists at the path provided.
     * @throws ClassCastException If the value is not of the correct type.
     * @throws IllegalArgumentException If null is supplied for the path
     * @return the value at the path
     */
    public List<String> getStringList(String path) {
        return (List<String>) retrieveValue(path);
    }


    /**
     * Returns all of the keys that exist in the configuration section at the supplied relative path.
     * If a value exists at the supplied path but it is not a configuration section then a {@link IllegalArgumentException}
     * is thrown. This set will include all keys at the supplied path, including those whose value's are configuration sections.
     *
     * @param path the path where the configuration section whose keys you wish to retrieve resides
     * @throws IllegalArgumentException a value that is not a configuration section exists at the supplied path
     * @throws IllegalArgumentException If null is supplied for the path
     * @throws NonexistentKeyException If no value exists at the path
     * @return the keys of the configuration section at the supplied path
     */
    public abstract Set<String> getKeys(String path);

    /**
     * Returns all of the keys that exist in the configuration section at the current path.
     * If the current path is no longer a configuration section, a {@link IllegalArgumentException} is thrown.
     * This set will include all keys at the current path, including those whose value's are configuration sections.
     *
     * @throws NonexistentKeyException
     * @return the path where the configuration section whose keys you wish to retrieve resides
     */
    public abstract Set<String> getKeys();

    /**
     * Returns true if a value exists at the supplied relative path. This will still return true if a value
     * exists at the path and is null. Note that some implementations prevent null values. This will also
     * return true if a configuration section exists at the supplied path.
     *
     * @param path the relative path to check
     * @throws IllegalArgumentException If null is supplied for the path
     * @return true if a value exists at the supplied relative path.
     */
    public abstract boolean doesValueExistAt(String path);

    /**
     * Returns a {@link ConfigurationSection} whose relative path is
     * that of the path supplied as an argument. If the path supplied
     * links to a value that is not a configuration section then a {@link IllegalArgumentException}
     * is thrown. This will return a new configuration section if one does not exist at the path
     * and another value does not already exist at the path.
     *
     * @param path the path
     * @throws IllegalArgumentException If a value other than a configuration section exists at the given path.
     * @return the ConfigurationSection associated with this path. (Never will be null)
     */
    public abstract ConfigurationSection getSection(String path);

    /**
     * Sets the given path's value to the given value. Setting a value to null will not delete the entry
     * in the configuration section, it will just set the value to null. Note that some implementations
     * do not allow null values.
     *
     * @param path the path (Cannot be null)
     * @throws IllegalArgumentException If null is supplied for the path
     * @param value the value
     */
    public abstract void set(String path, Object value);

    /**
     * Deletes the key at the supplied relative path. If no key exists at the path then a {@link NonexistentKeyException}
     * is thrown.
     *
     *
     * @param path the path (Cannot be null)
     * @throws IllegalArgumentException If null is supplied for the path
     * @throws NonexistentKeyException If no key exists at the path.
     * @param path the path of the key to delete
     */
    public abstract void delete(String path);

    /**
     * Retrieves the value located at the given relative path.
     *
     * This should be implemented by the configuration type.
     *
     * To avoid {@link NonexistentKeyException} use {@link #doesValueExistAt(String)}
     *
     * @throws NonexistentKeyException if the given key does not exist. Note that keys can still have null values. This
     * is only thrown when the key does not exist at all.
     * @param path the relative path of the value
     * @return the value stored at the supplied path
     */
    public abstract Object retrieveValue(String path);

    /**
     * Returns the type of the value located at the relative path.
     *
     * To avoid {@link NonexistentKeyException} use {@link #doesValueExistAt(String)}
     *
     * @throws NonexistentKeyException if the given key does not exist. Note that keys can still have null values. This
     * is only thrown when the key does not exist at all.
     * @param path the relative path of the value
     * @return the type of the value stored at the supplied path
     */
    public Class getValueType(String path) {
        Object value = retrieveValue(path);
        if (value == null) {
            return null;
        } else {
            return value.getClass();
        }
    }

    /**
     * Returns true if the value at the relative path is null.
     *
     * To avoid {@link NonexistentKeyException} use {@link #doesValueExistAt(String)}
     *
     * @throws NonexistentKeyException if the given key does not exist.
     * @param path the relative path of the value
     * @return if the value is null
     */
    public boolean isValueNull(String path) {
        if (retrieveValue(path) == null) {
            return true;
        }
        return false;
    }
}
