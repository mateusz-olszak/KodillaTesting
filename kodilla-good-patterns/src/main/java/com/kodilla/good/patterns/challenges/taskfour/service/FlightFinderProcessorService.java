package com.kodilla.good.patterns.challenges.taskfour.service;

import com.kodilla.good.patterns.challenges.taskfour.data.FlightDto;
import com.kodilla.good.patterns.challenges.taskfour.repository.FlightFinderRepository;

public class FlightFinderProcessorService {

    private FlightFinderRepository finderRepository;

    public FlightFinderProcessorService(FlightFinderRepository finderRepository) {
        this.finderRepository = finderRepository;
    }

    public void process(FlightDto flight){
        finderRepository.findFlightFrom(flight);
        finderRepository.findFlightTo(flight);
        finderRepository.findConnectedFlight(flight);
    }

}
