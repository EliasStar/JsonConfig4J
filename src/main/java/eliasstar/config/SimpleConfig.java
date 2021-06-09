/*
 * Copyright (C) 2021 Elias*
 *
 * This file is part of JsonConfig4J.
 *
 * JsonConfig4J is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or any later version.
 *
 * JsonConfig4J is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * JsonConfig4J. If not, see <https://www.gnu.org/licenses/>.
 */
package eliasstar.config;

import java.nio.file.Files;
import java.nio.file.Paths;

import eliasstar.json.objects.JsonArray;
import eliasstar.json.objects.JsonObject;

/**
 * Wrapper around Config with setp function.
 *
 * @author Elias*
 * @since 1.0.0
 */
public abstract class SimpleConfig extends Config {

    private String configPath = "cfg/config.json";
    private int maxUpdateTries = 5;

    public SimpleConfig() {
        setup();
    }

    public abstract void setup();

    public void update() {
        try {
            if (Files.exists(Paths.get(configPath))) {
                load(configPath, maxUpdateTries, this);
            } else if (Files.notExists(Paths.get(configPath))) {
                save(configPath, maxUpdateTries, this);
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changeSettings(String configPath, int maxUpdateTries) {
        this.configPath = configPath;
        this.maxUpdateTries = maxUpdateTries;
    }

    public String getConfigPath() {
        return configPath;
    }

    public int getMaxUpdateTries() {
        return maxUpdateTries;
    }

    public void setChar(String name, char value) {
        set(name, value);
    }

    public char getChar(String name) {
        return (char) get(name);
    }

    public void setByte(String name, byte value) {
        set(name, value);
    }

    public byte getByte(String name) {
        return ((Number) get(name)).byteValue();
    }

    public void setShort(String name, short value) {
        set(name, value);
    }

    public short getShort(String name) {
        return ((Number) get(name)).shortValue();
    }

    public void setInt(String name, int value) {
        set(name, value);
    }

    public int getInt(String name) {
        return ((Number) get(name)).intValue();
    }

    public void setLong(String name, long value) {
        set(name, value);
    }

    public long getLong(String name) {
        return ((Number) get(name)).longValue();
    }

    public void setFloat(String name, float value) {
        set(name, value);
    }

    public float getFloat(String name) {
        return ((Number) get(name)).floatValue();
    }

    public void setDouble(String name, double value) {
        set(name, value);
    }

    public double getDouble(String name) {
        return ((Number) get(name)).doubleValue();
    }

    public void setBoolean(String name, boolean value) {
        set(name, value);
    }

    public boolean getBoolean(String name) {
        return (boolean) get(name);
    }

    public void setString(String name, String value) {
        set(name, value);
    }

    public String getString(String name) {
        return (String) get(name);
    }

    public void setJsonArray(String name, JsonArray value) {
        set(name, value);
    }

    public JsonArray getJsonArray(String name) {
        return (JsonArray) get(name);
    }

    public void setJsonObject(String name, JsonObject value) {
        set(name, value);
    }

    public JsonObject getJsonObject(String name) {
        return (JsonObject) get(name);
    }

    public void setConfig(String name, Config value) {
        set(name, value);
    }

    public Config getConfig(String name) {
        return super.getConfig(name);
    }
}