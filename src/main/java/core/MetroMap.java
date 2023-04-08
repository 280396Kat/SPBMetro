package core;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class MetroMap {
    private final JSONObject jsonObject;

    public MetroMap(JSONObject stationObject, JSONArray line, JSONArray connections) {
        jsonObject = new JSONObject();
        jsonObject.put("stations", stationObject);
        jsonObject.put("lines", line);
        jsonObject.put("connections", connections);
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }
}
