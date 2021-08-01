package com.kodilla.good.patterns.challenges.taskfour.service;

import com.kodilla.good.patterns.challenges.taskfour.data.Flight;
import com.kodilla.good.patterns.challenges.taskfour.data.FlightDto;

import java.util.ArrayList;
import java.util.List;

public class FlightDataRetrieverService {
    public FlightDto retrieve(){
        String cityFrom = "Warszawa";
        String cityTo = "Wrocław";
        List<Flight> flights = prepareFlights();

        return new FlightDto(flights,cityFrom,cityTo);
    }
    private List<Flight> prepareFlights(){
        Flight f1 = new Flight("Gdańsk", "Poznań");
        Flight f2 = new Flight("Warszawa", "Poznań");
        Flight f3 = new Flight("Kraków", "Gdańsk");
        Flight f4 = new Flight("Łódź", "Gdańsk");
        Flight f5 = new Flight("Kraków", "Warszawa");
        Flight f6 = new Flight("Wrocław", "Kraków");
        Flight f7 = new Flight("Kraków", "Wrocław");
        Flight f8 = new Flight("Gdańsk", "Kraków");
        Flight f9 = new Flight("Poznań", "Wrocław");

        List<Flight> flights = new ArrayList<>();
        flights.add(f1);
        flights.add(f2);
        flights.add(f3);
        flights.add(f4);
        flights.add(f5);
        flights.add(f6);
        flights.add(f7);
        flights.add(f8);
        flights.add(f9);

        return flights;
    }
}
