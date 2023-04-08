package core;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParserWeb {

    private Document document;
    private List<Line> lines;
    private MemoryStations memoryStations;
    private DataMemoryCollector dataMemoryCollector;

    public ParserWeb(String url) throws IOException {
       document = Jsoup.connect(url).maxBodySize(0).get();
       lines = new ArrayList<>();
       dataMemoryCollector = new DataMemoryCollector();
    }

    public List<Line> getLines() {
        return lines;
    }

    public MemoryStations getMemoryStations() {
        return memoryStations;
    }

    public DataMemoryCollector getDataMemoryCollector() {
        return dataMemoryCollector;
    }

    public JSONArray parserLine() {
        Elements elements = document.getElementsByAttributeValueStarting(
                "class", "js-metro-line t-metrostation-list-header t-icon-metroln ln");
        JSONArray jsonArray = new JSONArray();
        for (Element element : elements) {
            Line line = new Line(element.attr("data-line"), element.ownText());
            jsonArray.add(line.getJsonObject());
            lines.add(line);
        }
        return jsonArray;
    }

    public JSONObject parserStation() {
        Elements elements = document.getElementsByClass("js-metro-stations t-metrostation-list-table");
        JSONObject jsonObject = new JSONObject();
        for (Element element : elements) {
            JSONArray stationArray = new JSONArray();
            Elements stations = element.getElementsByClass("name");
            for (Element station : stations) {
                stationArray.add(station.text());
                jsonObject.put(element.attr("data-line"), stationArray);
                memoryStations.addStation(new Station(station.text(), element.attr("data-line")));
            }
        }
        return jsonObject;
    }


}


