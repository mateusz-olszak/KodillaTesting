package com.kodilla.good.patterns.challenges.taskfour.service;

import com.kodilla.good.patterns.challenges.taskfour.data.Flight;
import com.kodilla.good.patterns.challenges.taskfour.data.FlightDto;
import com.kodilla.good.patterns.challenges.taskfour.repository.FlightFinderRepository;

import java.util.List;
import java.util.stream.Collectors;

public class FlightToFinderService implements FlightFinderRepository {
    @Override
    public void findFlight(FlightDto flight) {
        List<Flight> flightsFrom = flight.getFlights().stream().filter(f -> f.getArrivalAirport().equals(flight.getFlightTo())).collect(Collectors.toList());

        flightsFrom.stream().forEach(System.out::println);
    }
}
