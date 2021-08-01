package com.kodilla.good.patterns.challenges.taskfour.repository;

import com.kodilla.good.patterns.challenges.taskfour.data.FlightDto;

import java.util.List;

public interface FlightFinderRepository {

    void findFlightFrom(FlightDto flight);

    void findFlightTo(FlightDto flight);

    void findConnectedFlight(FlightDto flight);
}
