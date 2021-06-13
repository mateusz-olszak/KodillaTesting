package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {

    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()){
            resultMap.put(temperature.getKey(), temperature.getValue()+1.0);
        }

        return resultMap;
    }

    public double calculateAverageTemperature(){
        double sum=0;

        for (Map.Entry<String, Double> temperature : temperatures.getAverageTemperature().entrySet()){
            sum += temperature.getValue();
        }

        return sum/temperatures.getAverageTemperature().size();
    }

    public double calculateMedianTemperature(){
        double[] temps = new double[temperatures.getMedianTemperature().size()];
        double median;
        int i=0;

        for (Map.Entry<String, Double> temperature : temperatures.getMedianTemperature().entrySet()){
            temps[i] = temperature.getValue();
            i++;
        }

        Arrays.sort(temps);

        if(temps.length % 2 == 0)
            median = (temps[temps.length/2-1] + temps[temps.length/2])/2;
        else
            median = temps[temps.length/2];

        return median;
    }

}
