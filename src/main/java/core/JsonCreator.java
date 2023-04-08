package core;

import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class JsonCreator {

    public void writerInJsonFile(JSONObject object, String path) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        fileWriter.write(object.toJSONString());
        fileWriter.flush();
        fileWriter.close();
    }
}
