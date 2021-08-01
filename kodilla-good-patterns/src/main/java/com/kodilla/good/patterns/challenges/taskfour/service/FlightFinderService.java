package com.kodilla.good.patterns.challenges.taskfour.service;

import com.kodilla.good.patterns.challenges.taskfour.data.Flight;
import com.kodilla.good.patterns.challenges.taskfour.data.FlightDto;
import com.kodilla.good.patterns.challenges.taskfour.repository.FlightFinderRepository;

import java.util.List;
import java.util.stream.Collectors;

public class FlightFinderService implements FlightFinderRepository {
    @Override
    public void findFlightFrom(FlightDto flight) {
        System.out.println("\n-------------- Find available flights from particular airport");
        List<Flight> flightsFrom = flight.getFlights().stream().filter(f -> f.getDepartureAirport().equals(flight.getFlightFrom())).collect(Collectors.toList());

        flightsFrom.stream().forEach(System.out::println);
    }

    @Override
    public void findFlightTo(FlightDto flight) {
        System.out.println("\n-------------- Find destination airport");
        List<Flight> flightsFrom = flight.getFlights().stream().filter(f -> f.getArrivalAirport().equals(flight.getFlightTo())).collect(Collectors.toList());

        flightsFrom.stream().forEach(System.out::println);
    }

    @Override
    public void findConnectedFlight(FlightDto flight) {
        System.out.println("\n-------------- Find connected flight");
        List<String> arrival = flight.getFlights().stream().filter(f -> f.getDepartureAirport().equals(flight.getFlightFrom()) && !f.getArrivalAirport().equals(flight.getFlightTo())).map(e -> e.getArrivalAirport()).collect(Collectors.toList());
        List<String> aD = flight.getFlights().stream().filter(f -> arrival.contains(f.getDepartureAirport()) && f.getArrivalAirport().equals(flight.getFlightTo())).map(e -> e.getDepartureAirport()).collect(Collectors.toList());

        List<Flight> connectionTo = flight.getFlights().stream().filter(f -> f.getDepartureAirport().equals(flight.getFlightFrom()) && aD.contains(f.getArrivalAirport())).collect(Collectors.toList());
        List<Flight> connectionAfter = flight.getFlights().stream().filter(f -> aD.contains(f.getDepartureAirport()) && f.getArrivalAirport().equals(flight.getFlightTo())).collect(Collectors.toList());

        connectionTo.forEach(System.out::println);
        connectionAfter.forEach(System.out::println);
    }
}
