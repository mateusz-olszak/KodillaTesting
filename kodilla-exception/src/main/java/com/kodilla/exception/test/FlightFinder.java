package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightFinder {

    private final Map<String, Boolean> flights = new HashMap<>();

    public FlightFinder() {
        flights.putIfAbsent("New York JFK Airport",true);
        flights.putIfAbsent("Warsaw Chopin Airport",true);
        flights.putIfAbsent("London Heathrow Airport",true);
        flights.putIfAbsent("Sydney Airport",true);
        flights.putIfAbsent("Dubai International Airport",true);
    }

    public String findFlight(Flight flight) throws RouteNotFoundException{
        boolean enabledFlight = flights.entrySet().stream()
                                .anyMatch(n -> n.getKey().contains(flight.getArrivalAirport()) && n.getValue().booleanValue());

        if (enabledFlight)
            return "Flight is possible";
        else
            throw new RouteNotFoundException("Flight is impossible");
    }

}
