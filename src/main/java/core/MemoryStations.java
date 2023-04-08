package core;

import java.util.List;
import java.util.Objects;
import java.util.TreeSet;

public class MemoryStations {

    private final List<Station> stations;
    private final TreeSet<Connections> connections; // мы можем сортировать конекшнс внутри коллекции, потому что класс конекшн реализует интерфейс комперебл

    public MemoryStations(List<Station> stations, TreeSet<Connections> connections) {
        this.stations = stations;
        this.connections = connections;
    }

    public List<Station> getStations() {
        return stations;
    }

    public TreeSet<Connections> getConnections() {
        return connections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MemoryStations)) return false;
        MemoryStations that = (MemoryStations) o;
        return Objects.equals(stations, that.stations) && Objects.equals(connections, that.connections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stations, connections);
    }

    public void addStation(Station station) {
        stations.add(station);
    }

    public void addConnection(Connections stationConnections) {
        if (!containsStation(stationConnections)) {
            connections.add(stationConnections);
        }
    }
    // рельный пример инкапсуляции в классе
    private boolean containsStation(Connections connectionSta) {
        for (Connections connectionsStation : connections) {
            for (Station station : connectionsStation.getConnectionStations()) {
                for (Station tmp : connectionSta.getConnectionStations()) {
                    if (station.getName().equals(tmp.getName()) && station.getNumberLine().equals(tmp)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
