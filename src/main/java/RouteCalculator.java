import core.Station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

//public class RouteCalculator {
//    private final StationIndex stationIndex;

//    private static final double INTER_STATION_DURATION = 2.5;
//    private static final double INTER_CONNECTION_DURATION = 3.5;
//
//    public RouteCalculator(StationIndex stationIndex) {
//        this.stationIndex = stationIndex;
//    }
//
//    public List<Station> getShortestRoute(Station from, Station to) {
//        List<Station> route = getRouteOnTheLine(from, to);
//        if (route != null) {
//            return route;
//        }
//
//        route = getRouteWithOneConnection(from, to);
//        assert route != null;
//        if (route.size() != 0) {
//            return route;
//        }
//
//        route = getRouteWithTwoConnections(from, to);
//        return route;
//    }
//
//    public static double calculateDuration(List<Station> route) {
//        double duration = 0;
//        Station previousStation = null;
//        for (int i = 0; i < route.size(); i++) {
//            Station station = route.get(i);
//            if (i > 0) {
//                duration += previousStation.getLine().equals(station.getLine()) ?
//                        INTER_STATION_DURATION : INTER_CONNECTION_DURATION;
//            }
//            previousStation = station;
//        }
//        return duration;
//    }
//
//
//
//
////    private List<Station> getRouteWithTwoConnections(Station from, Station to) {
////        if (from.getLine().equals(to.getLine())) {
////            return null;
////        }
////
////        ArrayList<Station> route = new ArrayList<>();
////
////        List<Station> fromLineStations = from.getLine().getStations();
////        List<Station> toLineStations = to.getLine().getStations();
////
////        for (Station srcStation : fromLineStations) {
////            for (Station dstStation : toLineStations) {
////                List<Station> connectedLineRoute =
////                        getRouteViaConnectedLine(srcStation, dstStation);
////                if (connectedLineRoute == null) {
////                    continue;
////                }
////                List<Station> way = new ArrayList<>();
////                way.addAll(getRouteOnTheLine(from, srcStation));
////                way.addAll(connectedLineRoute);
////                way.addAll(getRouteOnTheLine(dstStation, to));
////                if (route.isEmpty() || route.size() > way.size()) {
////                    route.clear();
////                    route.addAll(way);
////                }
////            }
////        }
////
////        return route;
////    }
//}