package core;

import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line implements Comparable<Line> {
    private final JSONObject jsonObject;
    private final String number;
    private final String name;

    public Line(String number, String name) {
        jsonObject = new JSONObject();
        jsonObject.put("number", number);
        jsonObject.put("name", name);
        this.number = number;
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        Line line = (Line) o;
        return Objects.equals(jsonObject, line.jsonObject) && Objects.equals(number, line.number) && Objects.equals(name, line.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jsonObject, number, name);
    }

    @Override
    public String toString() {
        return "Line{" +
                "jsonObject=" + jsonObject +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Line line) {
        return number.compareToIgnoreCase(line.getNumber());
    }
}
