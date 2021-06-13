package com.kodilla.testing.weather.stub;

import java.util.Map;

public interface Temperatures {

    Map<String, Double> getTemperatures();

    Map<String, Double> getAverageTemperature();

    Map<String, Double> getMedianTemperature();

}
