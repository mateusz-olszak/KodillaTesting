package com.kodilla.good.patterns.challenges.taskfour.service;

import com.kodilla.good.patterns.challenges.taskfour.data.Flight;
import com.kodilla.good.patterns.challenges.taskfour.data.FlightDto;
import com.kodilla.good.patterns.challenges.taskfour.repository.FlightFinderRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ConnectedFlightFinderService implements FlightFinderRepository {
    @Override
    public void findFlight(FlightDto flight) {
        List<String> arrival = flight.getFlights().stream().filter(f -> flight.getFlightFrom().equals(f.getDepartureAirport()) && !flight.getFlightTo().equals(f.getArrivalAirport())).map(e -> e.getArrivalAirport()).collect(Collectors.toList());

        List<Flight> flights = flight.getFlights().stream().filter(f -> flight.getFlightFrom().equals(f.getDepartureAirport()) && !flight.getFlightTo().equals(f.getArrivalAirport()) || flight.getFlightTo().equals(f.getArrivalAirport()) && arrival.contains(f.getDepartureAirport())).collect(Collectors.toList());

        flights.forEach(System.out::println);
    }
}
