package eliasstar.config;

import java.nio.file.Files;
import java.nio.file.Paths;

import eliasstar.json.objects.JSONArray;
import eliasstar.json.objects.JSONObject;

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

    public void setJSONArray(String name, JSONArray value) {
        set(name, value);
    }

    public JSONArray getJSONArray(String name) {
        return (JSONArray) get(name);
    }

    public void setJSONObject(String name, JSONObject value) {
        set(name, value);
    }

    public JSONObject getJSONObject(String name) {
        return (JSONObject) get(name);
    }

    public void setConfig(String name, Config value) {
        set(name, value);
    }

    public Config getConfig(String name) {
        return super.getConfig(name);
    }
}