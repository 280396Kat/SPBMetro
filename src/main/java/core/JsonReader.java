package core;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonReader {

    public void getAmountOfStation(String path) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        Object object = jsonParser.parse(new FileReader(path));
        JSONObject jsonObject = (JSONObject) object;
        JSONObject stationObject =(JSONObject) jsonObject.get("stations");
        stationObject.keySet().forEach(line -> {
            JSONArray stationArray = (JSONArray) stationObject.get(line);
            System.out.println("Линия" + line + " Количество станций" + stationArray.size());
        });

    }
}
