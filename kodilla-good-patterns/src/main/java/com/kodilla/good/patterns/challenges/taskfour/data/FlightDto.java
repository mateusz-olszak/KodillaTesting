package com.kodilla.good.patterns.challenges.taskfour.data;

import java.util.List;

public class FlightDto {

    private final List<Flight> flights;
    private final String flightFrom;
    private final String flightTo;

    public FlightDto(final List<Flight> flights,final String flightFrom,final String flightTo) {
        this.flights = flights;
        this.flightFrom = flightFrom;
        this.flightTo = flightTo;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public String getFlightFrom() {
        return flightFrom;
    }

    public String getFlightTo() {
        return flightTo;
    }

}
