package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {

    @Test
    public void  testGetPeopleQuantity(){
        Continent continent = new Continent();
        continent.addCountry(new Poland());
        continent.addCountry(new Germany());
        continent.addCountry(new France());
        World world = new World();
        world.addContinent(continent);

        BigDecimal expectedPeople = new BigDecimal(188000000);
        BigDecimal totalPeople = world.getPeopleQuantity();

        assertEquals(expectedPeople, totalPeople);

    }

}
