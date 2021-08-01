package com.kodilla.good.patterns.challenges.taskfour.service;

import com.kodilla.good.patterns.challenges.taskfour.data.Flight;
import com.kodilla.good.patterns.challenges.taskfour.data.FlightDto;
import com.kodilla.good.patterns.challenges.taskfour.repository.FlightFinderRepository;

import java.util.List;
import java.util.stream.Collectors;


public class FlightFromFinderService implements FlightFinderRepository {
    @Override
    public void findFlight(FlightDto flight) {
        List<Flight> flightsFrom = flight.getFlights().stream().filter(f -> f.getDepartureAirport().equals(flight.getFlightFrom())).collect(Collectors.toList());

        flightsFrom.stream().forEach(System.out::println);
    }
}
