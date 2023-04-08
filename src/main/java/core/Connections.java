package core;

import java.util.Objects;
import java.util.TreeSet;

public class Connections implements Comparable<Connections>{ // написали имплементс, потому что коллекция не знает как делать сортировку
    private final TreeSet<Station> connectionStations;

    public Connections(TreeSet<Station> connectionStations) {
        this.connectionStations = connectionStations;
    }

    public TreeSet<Station> getConnectionStations() {
        return connectionStations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Connections)) return false;
        Connections that = (Connections) o;
        return Objects.equals(connectionStations, that.connectionStations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(connectionStations);
    }

    public void addStation(Station station) {
        connectionStations.add(station);

    }

    @Override
    public int compareTo(Connections stationsConnection) {
        if (connectionStations.size() == stationsConnection.getConnectionStations().size()) {
            if (connectionStations.containsAll(stationsConnection.getConnectionStations())) {
                return 0;
            } else {
                return -1;
            }
        }
        if (connectionStations.size() < stationsConnection.getConnectionStations().size()) {
            return -1;
        }
        return 1;
    }
}
