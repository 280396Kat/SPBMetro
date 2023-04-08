import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RouteCalculatorTest extends TestCase {

    List<Station> route;
    List<Station> route1;
    List<Station> route2;


    StationIndex stationIndex = new StationIndex();

    RouteCalculator routeCalculator;


    @Override
    protected void setUp() throws Exception {


        route = new ArrayList<>();
        route1 = new ArrayList<>();
        route2 = new ArrayList<>();

        routeCalculator = new RouteCalculator(stationIndex);

        Line line1 = new Line(1, "Первая");
        Line line2 = new Line(2, "Вторая");
        Line line3 = new Line(3, "Третья");

        Station station1 = new Station("Маяковская", line1);
        Station station2 = new Station("Бродская", line1);
        Station station3 = new Station("Булгаковская", line1);
        Station station4 = new Station("Тютчевская", line2);
        Station station5 = new Station("Пушкинская", line2);
        Station station6 = new Station("Достоевская", line2);
        Station station7 = new Station("Есенинская", line3);
        Station station8 = new Station("Толстовская", line3);
        Station station9 = new Station("Чеховская", line3);

        line1.addStation(station1);
        line1.addStation(station2);
        line1.addStation(station3);
        line2.addStation(station4);
        line2.addStation(station5);
        line2.addStation(station6);
        line3.addStation(station7);
        line3.addStation(station8);
        line3.addStation(station9);

        List<Station> connectionStations = new ArrayList<>();
        connectionStations.add(station2);
        connectionStations.add(station5);

        List<Station> connectionStations1 = new ArrayList<>();
        connectionStations1.add(station6);
        connectionStations1.add(station8);

        stationIndex.addConnection(connectionStations);
        stationIndex.addConnection(connectionStations1);


        stationIndex.addStation(station1);
        stationIndex.addStation(station2);
        stationIndex.addStation(station3);
        stationIndex.addStation(station4);
        stationIndex.addStation(station5);
        stationIndex.addStation(station6);
        stationIndex.addStation(station7);
        stationIndex.addStation(station8);
        stationIndex.addStation(station9);

        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);

        route.add(station1);
        route.add(station2);
        route.add(station5);
        route.add(station6);

        route1.add(station1);
        route1.add(station2);
        route1.add(station3);

        route2.add(station1);
        route2.add(station2);
        route2.add(station5);
        route2.add(station6);
        route2.add(station8);
        route2.add(station9);
    }

    public void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 8.5;
        assertEquals(expected, actual);
    }

    public void testGetShortestRouteOneLine() {
        List<Station> actual = routeCalculator.getShortestRoute(
                stationIndex.getStation("Маяковская", 1),
                stationIndex.getStation("Булгаковская", 1));
        List<Station> expected = route1;
        assertEquals(expected, actual);
    }

    public void testGetShortestRouteTwoLine() {
        List<Station> actual = routeCalculator.getShortestRoute(
                stationIndex.getStation("Маяковская", 1),
                stationIndex.getStation("Достоевская", 2));
        List<Station> expected = route;
        assertEquals(expected, actual);
    }

    public void testGetShortestRouteThreeLine() {
        List<Station> actual = routeCalculator.getShortestRoute(
                stationIndex.getStation("Маяковская", 1),
                stationIndex.getStation("Чеховская", 3));
        List<Station> expected = route2;
        assertEquals(expected, actual);
    }
}
