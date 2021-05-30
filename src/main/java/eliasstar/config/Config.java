package eliasstar.config;

import java.io.IOException;

import json.JSON;
import json.classes.JSONObject;
import json.exceptions.JSONException;
import json.interfaces.JSONSerializable;

public class Config implements JSONSerializable {

    private final JSONObject currentConfig = new JSONObject();
    private final JSONObject defaultConfig = new JSONObject();

    public Config() {
    }

    private Config(JSONObject object) {
        replaceWith(object);
    }

    public static void load(String configPath, int maxTries, Config config) throws IOException {
        for (int i = 0; i <= maxTries; i++) {
            try {
                config.replaceWith((JSONObject) JSON.readFile(configPath));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static void save(String configPath, int maxTries, Config config) throws IOException {
        for (int i = 0; i <= maxTries; i++) {
            try {
                JSON.writeFile(configPath, config);
                break;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void replaceWith(JSONObject object) {
        defaultConfig.setAllMembers(object.getAllMembers());
        currentConfig.setAllMembers(object.getAllMembers());
    }

    public Config getConfig(String name) {
        Object obj = currentConfig.getMember(name);

        if (obj instanceof Config) {
            return (Config) obj;
        }

        if (obj instanceof JSONObject) {
            return new Config((JSONObject) obj);
        }

        return null;
    }

    public Object get(String name) {
        return currentConfig.getMember(name);
    }

    public boolean set(String name, Object value) {
        currentConfig.setMember(name, value);

        if (!defaultConfig.existsMember(name)) {
            defaultConfig.setMember(name, value);
            return true;
        }

        return false;
    }

    public boolean reset(String name) {
        if (defaultConfig.existsMember(name)) {
            currentConfig.setMember(name, defaultConfig.getMember(name));
            return true;
        }
        return false;
    }

    @Override
    public String toJSON() {
        return currentConfig.toJSON();
    }
}