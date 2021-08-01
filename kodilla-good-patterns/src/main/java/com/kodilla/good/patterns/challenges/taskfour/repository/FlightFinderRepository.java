package com.kodilla.good.patterns.challenges.taskfour.repository;

import com.kodilla.good.patterns.challenges.taskfour.data.FlightDto;

import java.util.List;

public interface FlightFinderRepository {
    void findFlight(FlightDto flight);
}
