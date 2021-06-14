package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests(){
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests(){
        System.out.println("All tests are finished");
    }

    @BeforeEach
    public void beforeEveryTest(){
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Nested
    @DisplayName("Square Test Unit")
    class SquareTests{

        @Test
        public void testAddFigure(){
            Square square = new Square(5);
            ShapeCollector collector = new ShapeCollector();

            collector.addFigure(square);

            Assertions.assertEquals(square, collector.getFigure(0));

        }

        @Test
        public void testGetFigure(){
            Square square = new Square(5);
            ShapeCollector collector = new ShapeCollector();
            collector.addFigure(square);

            Shape figure = collector.getFigure(0);

            Assertions.assertEquals(square, figure);

        }

        @Test
        public void testRemoveFigure(){
            Square square = new Square(5);
            ShapeCollector collector = new ShapeCollector();
            collector.addFigure(square);

            boolean removeFigure = collector.removeFigure(square);

            Assertions.assertFalse(removeFigure);
        }

        @Test
        public void testShowFigures(){
            List<Shape> shapes = new ArrayList<>();
            Square square = new Square(5);
            Circle circle = new Circle(5);
            Triangle triangle = new Triangle(5,3);
            ShapeCollector collector = new ShapeCollector();
            shapes.add(square);
            shapes.add(circle);
            shapes.add(triangle);
            collector.addFigure(square);
            collector.addFigure(circle);
            collector.addFigure(triangle);

            List<Shape> expected = shapes;
            List<Shape> result = collector.showFigure();

            Assertions.assertEquals(expected, result);
        }

    }

    @Nested
    @DisplayName("Triangle Test Unit")
    class TriangleTests{

        @Test
        public void testAddFigure(){
            Triangle triangle = new Triangle(5, 3);
            ShapeCollector collector = new ShapeCollector();

            collector.addFigure(triangle);

            Assertions.assertEquals(triangle, collector.getFigure(0));

        }

        @Test
        public void testGetFigure(){
            Triangle triangle = new Triangle(5, 3);
            ShapeCollector collector = new ShapeCollector();
            collector.addFigure(triangle);

            Shape figure = collector.getFigure(0);

            Assertions.assertEquals(triangle, figure);

        }

        @Test
        public void testRemoveFigure(){
            Triangle triangle = new Triangle(5, 3);
            ShapeCollector collector = new ShapeCollector();
            collector.addFigure(triangle);

            boolean removeFigure = collector.removeFigure(triangle);

            Assertions.assertTrue(removeFigure);
        }

        @Test
        public void testShowFigures(){
            List<Shape> shapes = new ArrayList<>();
            Square square = new Square(5);
            Circle circle = new Circle(5);
            Triangle triangle = new Triangle(5,3);
            ShapeCollector collector = new ShapeCollector();
            shapes.add(square);
            shapes.add(circle);
            shapes.add(triangle);
            collector.addFigure(square);
            collector.addFigure(circle);
            collector.addFigure(triangle);

            List<Shape> expected = shapes;
            List<Shape> result = collector.showFigure();

            Assertions.assertEquals(expected, result);
        }

    }

    @Nested
    @DisplayName("Circle Test Unit")
    class CircleTests{

        @Test
        public void testAddFigure(){
            Circle circle = new Circle(10);
            ShapeCollector collector = new ShapeCollector();

            collector.addFigure(circle);

            Assertions.assertEquals(circle, collector.getFigure(0));

        }

        @Test
        public void testGetFigure(){
            Circle circle = new Circle(10);
            ShapeCollector collector = new ShapeCollector();
            collector.addFigure(circle);

            Shape figure = collector.getFigure(0);

            Assertions.assertEquals(circle, figure);

        }

        @Test
        public void testRemoveFigure(){
            Circle circle = new Circle(10);
            ShapeCollector collector = new ShapeCollector();
            collector.addFigure(circle);

            boolean removeFigure = collector.removeFigure(circle);

            Assertions.assertTrue(removeFigure);
        }

        @Test
        public void testShowFigures(){
            List<Shape> shapes = new ArrayList<>();
            Square square = new Square(5);
            Circle circle = new Circle(5);
            Triangle triangle = new Triangle(5,3);
            ShapeCollector collector = new ShapeCollector();
            shapes.add(square);
            shapes.add(circle);
            shapes.add(triangle);
            collector.addFigure(square);
            collector.addFigure(circle);
            collector.addFigure(triangle);

            List<Shape> expected = shapes;
            List<Shape> result = collector.showFigure();

            Assertions.assertEquals(expected, result);
        }

    }

}
