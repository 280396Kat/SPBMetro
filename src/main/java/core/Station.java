package core;

import java.util.Objects;

public class Station implements Comparable<Station> {

    private String numberLine;
    private String nameLine;
    private String name;
    private String date;
    private String depth;
    private boolean hasConnection;

    public Station(String numberLine, String nameLine, String name, String date, String depth, boolean hasConnection) {
        this.numberLine = numberLine;
        this.nameLine = nameLine;
        this.name = name;
        this.date = date;
        this.depth = depth;
        this.hasConnection = hasConnection;
    }

    public Station(String name) {
        this.name = name;
    }

    public Station(String numberLine, String name) {
        this.numberLine = numberLine;
        this.name = name;
    }

    public String getNumberLine() {
        return numberLine;
    }

    public String getNameLine() {
        return nameLine;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getDepth() {
        return depth;
    }

    public boolean isHasConnection() {
        return hasConnection;
    }

    public void setNumberLine(String numberLine) {
        this.numberLine = numberLine;
    }

    public void setNameLine(String nameLine) {
        this.nameLine = nameLine;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public void setHasConnection(boolean hasConnection) {
        this.hasConnection = hasConnection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Station)) return false;
        Station station = (Station) o;
        return hasConnection == station.hasConnection && Objects.equals(numberLine, station.numberLine) && Objects.equals(nameLine, station.nameLine) && Objects.equals(name, station.name) && Objects.equals(date, station.date) && Objects.equals(depth, station.depth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberLine, nameLine, name, date, depth, hasConnection);
    }

    @Override
    public String toString() {
        return "Station{" +
                "numberLine='" + numberLine + '\'' +
                ", nameLine='" + nameLine + '\'' +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", depth='" + depth + '\'' +
                ", hasConnection=" + hasConnection +
                '}';
    }

    @Override
    public int compareTo(Station o) {
        int line = numberLine.compareToIgnoreCase(o.getNumberLine());
        if (line != 0) {
            return line;
        }
        return name.compareToIgnoreCase(getName());
    }
}