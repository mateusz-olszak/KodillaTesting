package com.kodilla.patterns2.decorator.taxiportal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaxiOrderTestSuite {

    @Test
    void testBasicTaxiOrderGetCost() {
        // Given
        TaxiOrder theOrder = new BasicTaxiOrder();

        // When
        BigDecimal calculateCost = theOrder.getCost();

        // Then
        assertEquals(new BigDecimal(5), calculateCost);
    }

    @Test
    void testBasicTaxiOrderGetDescription() {
        // Given
        TaxiOrder theOrder = new BasicTaxiOrder();

        // When
        String desc = theOrder.getDescription();

        // Then
        assertEquals("Drive a course", desc);
    }

    @Test
    void testTaxiNetworkGetCost() {
        // Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder);
        // When
        BigDecimal theCost = theOrder.getCost();
        // Then
        assertEquals(new BigDecimal(40), theCost);
    }

    @Test
    void testTaxiNetworkGetDescription() {
        // Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder);
        // When
        String desc = theOrder.getDescription();
        // Then
        assertEquals("Drive a course by Taxi Network", desc);
    }

    @Test
    void testMyTaxiWithChildSeatGetCost() {
        // Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new MyTaxiNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        // When
        BigDecimal theCost = theOrder.getCost();
        // Then
        assertEquals(new BigDecimal(37), theCost);
    }

    @Test
    void testMyTaxiWithChildSeatGetDescription() {
        // Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new MyTaxiNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        // When
        String desc = theOrder.getDescription();
        // Then
        assertEquals("Drive a course by MyTaxi Network + child seat", desc);
    }

    @Test
    void testUberWithTwoChildSeatsGetCost() {
        // Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new UberNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        // When
        BigDecimal theCost = theOrder.getCost();
        // Then
        assertEquals(new BigDecimal(29), theCost);
    }

    @Test
    void testUberWithTwoChildSeatsGetDescription() {
        // Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new UberNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        // When
        String desc = theOrder.getDescription();
        // Then
        assertEquals("Drive a course by Uber Network + child seat + child seat", desc);
    }

    @Test
    void testVipTaxiWithChildSeatExpressGetCost() {
        // Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder);
        theOrder = new ExpresseDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        theOrder = new VipCarDecorator(theOrder);
        // When
        BigDecimal theCost = theOrder.getCost();
        // Then
        assertEquals(new BigDecimal(57), theCost);
    }

    @Test
    void testVipTaxiWithChildSeatExpressGetDescription() {
        // Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder);
        theOrder = new ExpresseDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        theOrder = new VipCarDecorator(theOrder);
        // When
        String desc = theOrder.getDescription();
        // Then
        assertEquals("Drive a course by Taxi Network + express service + child seat + variant VIP", desc);
    }
}
