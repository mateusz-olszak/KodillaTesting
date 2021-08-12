package com.kodilla.patterns.strategy;

import com.kodilla.patterns.strategy.predictors.AggressivePredictor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTestSuite {

    @Test
    void testDefaultInvestingStrategies(){
        Customer steven = new IndividualCustomer("Steven Links");
        Customer john = new IndividualYoungCustomer("John Hemerald");
        Customer mati = new CorporateCustomer("Mateusz Olszak");

        String stevenShouldBuy = steven.predict();
        System.out.println("Steven should: " + stevenShouldBuy);
        String johnShouldBuy = john.predict();
        System.out.println("John should: " + johnShouldBuy);
        String matiShouldBuy = mati.predict();
        System.out.println("Mati should: " + matiShouldBuy);

        assertEquals("[Conservative predictor] Buy debentures of XYZ",stevenShouldBuy);
        assertEquals("[Aggressive predictor] Buy stock of XYZ",johnShouldBuy);
        assertEquals("[Balanced predictor] Buy shared units of Fund XYZ",matiShouldBuy);
    }

    @Test
    void testIndividualInvestingStrategy(){
        Customer steven = new IndividualCustomer("Steven Links");

        String stevenShouldBuy = steven.predict();
        System.out.println("Steven should: " + stevenShouldBuy);
        steven.setBuyPredictor(new AggressivePredictor());
        stevenShouldBuy = steven.predict();
        System.out.println("Steven now should: " + stevenShouldBuy);

        assertEquals("[Aggressive predictor] Buy stock of XYZ",stevenShouldBuy);
    }

}
