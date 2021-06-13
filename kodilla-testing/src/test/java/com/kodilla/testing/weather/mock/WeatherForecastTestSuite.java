package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WeatherForecastTestSuite {

    @Mock
    private Temperatures temperaturesMock;

    private static int counter = 1;

    @BeforeAll
    public static void beforeAll(){
        System.out.println("Test Unit: begin");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("Test Unit: end");
    }

    @BeforeEach
    void beforeEachTest(){
        System.out.println("Start test number #" + counter);
        counter++;
    }

    @AfterEach
    void afterEachTest(){
        System.out.println("End test");
    }

    @Test
    void testCalculateForecastWithMock(){
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow", 25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        int quantityOfSensors = weatherForecast.calculateForecast().size();

        Assertions.assertEquals(5, quantityOfSensors);

    }

    @Test
    void testCalculateAverageTemperature(){
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow", 10.0);
        temperaturesMap.put("Krakow", 10.0);
        temperaturesMap.put("Wroclaw", 10.0);
        temperaturesMap.put("Warszawa", 10.0);
        temperaturesMap.put("Gdansk", 10.0);
        when(temperaturesMock.getAverageTemperature()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        double averageTemperature = weatherForecast.calculateAverageTemperature();

        Assertions.assertEquals(10, averageTemperature);
    }

    @Test
    void testCalculateMedianTemperature(){
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow", 40.0);
        temperaturesMap.put("Krakow", 30.0);
        temperaturesMap.put("Wroclaw", 50.0);
        temperaturesMap.put("Warszawa", 10.0);
//        temperaturesMap.put("Gdansk", 20.0);
        when(temperaturesMock.getMedianTemperature()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        double medianTemperature = weatherForecast.calculateMedianTemperature();

        Assertions.assertEquals(35, medianTemperature);
    }

}
