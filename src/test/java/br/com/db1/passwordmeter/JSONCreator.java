package br.com.db1.passwordmeter;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONCreator {

    private final JSONObject json;

    private JSONCreator() {
        this.json = new JSONObject();
    }

    public static JSONCreator builder() {
        return new JSONCreator();
    }

    public JSONCreator put(String attr, Object value) throws JSONException {
        this.json.put(attr, value);
        return this;
    }

    public JSONObject build() {
        return this.json;
    }
}
