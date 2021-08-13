package com.kodilla.patterns.factory;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShapeFactoryTestSuite {

    private static int counter = 1;

    @BeforeAll
    static void startTests(){
        System.out.println("TESTS SUITE STARTS");
    }

    @AfterAll
    static void endTests(){
        System.out.println("TESTS SUITE ENDS");
    }

    @BeforeEach
    void startTest(){
        System.out.println("test number: " + counter);
        counter++;
    }

    @Test
    void testFactoryCircle(){
        ShapeFactory factory = new ShapeFactory();

        Shape circle = factory.makeShape(ShapeFactory.CIRCLE);
        System.out.println(circle.getName());

        assertEquals(Math.PI * Math.pow(4.50,2.0),circle.getArea(),0);
        assertEquals("The rounded circle", circle.getName());
    }

    @Test
    void testFactorySquare(){
        ShapeFactory factory = new ShapeFactory();

        Shape square = factory.makeShape(ShapeFactory.SQUARE);
        System.out.println(square.getName());

        assertEquals("The angular square", square.getName());
    }

    @Test
    void testFactoryRectangle(){
        ShapeFactory factory = new ShapeFactory();

        Shape rectangle = factory.makeShape(ShapeFactory.RECTANGLE);
        System.out.println(rectangle.getName());

        assertEquals("The long rectangle",rectangle.getName());
    }

}
