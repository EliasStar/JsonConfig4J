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

import java.io.IOException;

import eliasstar.json.JSON;
import eliasstar.json.objects.JSONObject;
import eliasstar.json.exceptions.JSONException;
import eliasstar.json.JSONSerializable;

/**
 * A basic config with default store.
 *
 * @author Elias*
 * @since 1.0.0
 */
public class Config implements JSONSerializable {

    private final JSONObject currentConfig = new JSONObject();
    private final JSONObject defaultConfig = new JSONObject();

    public Config() {}

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

        if (obj instanceof Config)
            return (Config) obj;

        if (obj instanceof JSONObject)
            return new Config((JSONObject) obj);

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