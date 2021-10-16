package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PizzaOrderTestSuite {

    @Test
    void testBasicPizzaCost() {
        // Given
        PizzaOrder basicPizzaDelegat = new BasicPizzaDelegat();
        // When
        BigDecimal theCost = basicPizzaDelegat.getCost();
        // Then
        assertEquals(new BigDecimal(15), theCost);
    }

    @Test
    void testBasicPizzaDescription() {
        // Given
        PizzaOrder basicPizzaDelegat = new BasicPizzaDelegat();
        // When
        List<String> pizzaIng = basicPizzaDelegat.getIngredients();
        // Then
        assertEquals(3, pizzaIng.size());
        assertTrue(pizzaIng.contains("Fat dough"));

        System.out.println(pizzaIng);
    }

    @Test
    void testCapricciosaPizzaCost() {
        // Given
        PizzaOrder basicPizzaDelegat = new BasicPizzaDelegat();
        basicPizzaDelegat = new PizzaCapricciosaDecorator(basicPizzaDelegat);
        // When
        BigDecimal theCost = basicPizzaDelegat.getCost();
        // Then
        assertEquals(new BigDecimal(20), theCost);
    }

    @Test
    void testCapricciosaPizzaDescription() {
        // Given
        PizzaOrder basicPizzaDelegat = new BasicPizzaDelegat();
        basicPizzaDelegat = new PizzaCapricciosaDecorator(basicPizzaDelegat);
        // When
        List<String> pizzaIng = basicPizzaDelegat.getIngredients();
        // Then
        assertEquals(6, pizzaIng.size());
        assertTrue(pizzaIng.contains("Mushrooms"));

        System.out.println(pizzaIng);
    }

    @Test
    void testNeapolitanianPizzaCost() {
        // Given
        PizzaOrder basicPizzaDelegat = new BasicPizzaDelegat();
        basicPizzaDelegat = new PizzaNeapolitanianDecorator(basicPizzaDelegat);
        // When
        BigDecimal theCost = basicPizzaDelegat.getCost();
        // Then
        assertEquals(new BigDecimal(25), theCost);
    }

    @Test
    void testNeapolitanianPizzaDescription() {
        // Given
        PizzaOrder basicPizzaDelegat = new BasicPizzaDelegat();
        basicPizzaDelegat = new PizzaNeapolitanianDecorator(basicPizzaDelegat);
        // When
        List<String> pizzaIng = basicPizzaDelegat.getIngredients();
        // Then
        assertEquals(7, pizzaIng.size());
        assertTrue(pizzaIng.contains("Fresh Basil"));
        assertFalse(pizzaIng.contains("Mushrooms"));

        System.out.println(pizzaIng);
    }

    @Test
    void testCapricciosaPizzaWithExtraSauceCost() {
        // Given
        PizzaOrder basicPizzaDelegat = new BasicPizzaDelegat();
        basicPizzaDelegat = new PizzaCapricciosaDecorator(basicPizzaDelegat);
        basicPizzaDelegat = new ExtraSauceDecorator(basicPizzaDelegat);
        // When
        BigDecimal theCost = basicPizzaDelegat.getCost();
        // Then
        assertEquals(new BigDecimal(22), theCost);
    }

    @Test
    void testCapricciosaPizzaWithExtraSauceDescription() {
        // Given
        PizzaOrder basicPizzaDelegat = new BasicPizzaDelegat();
        basicPizzaDelegat = new PizzaCapricciosaDecorator(basicPizzaDelegat);
        basicPizzaDelegat = new ExtraSauceDecorator(basicPizzaDelegat);
        // When
        List<String> pizzaIng = basicPizzaDelegat.getIngredients();
        // Then
        assertEquals(7, pizzaIng.size());
        assertTrue(pizzaIng.contains("Extra Sauce"));

        System.out.println(pizzaIng);
    }

    @Test
    void testNeapolitanianPizzaWithExtraSauceAndThinDoughCost() {
        // Given
        PizzaOrder basicPizzaDelegat = new BasicPizzaDelegat();
        basicPizzaDelegat = new PizzaNeapolitanianDecorator(basicPizzaDelegat);
        basicPizzaDelegat = new ExtraSauceDecorator(basicPizzaDelegat);
        basicPizzaDelegat = new ThinCrustPizzaDecorator(basicPizzaDelegat);
        // When
        BigDecimal theCost = basicPizzaDelegat.getCost();
        // Then
        assertEquals(new BigDecimal(27), theCost);
    }

    @Test
    void testNeapolitanianPizzaWithExtraSauceAndThinDoughDescription() {
        // Given
        PizzaOrder basicPizzaDelegat = new BasicPizzaDelegat();
        basicPizzaDelegat = new PizzaNeapolitanianDecorator(basicPizzaDelegat);
        basicPizzaDelegat = new ExtraSauceDecorator(basicPizzaDelegat);
        basicPizzaDelegat = new ThinCrustPizzaDecorator(basicPizzaDelegat);
        // When
        List<String> pizzaIng = basicPizzaDelegat.getIngredients();
        // Then
        assertEquals(8, pizzaIng.size());
        assertTrue(pizzaIng.contains("Fresh Basil"));
        assertTrue(pizzaIng.contains("Thin dough"));
        assertFalse(pizzaIng.contains("Mushrooms"));
        assertFalse(pizzaIng.contains("Fat dough"));

        System.out.println(pizzaIng);
    }
}
