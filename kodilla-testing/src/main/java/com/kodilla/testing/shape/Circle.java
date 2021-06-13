package com.kodilla.testing.shape;

public class Circle implements Shape {

    private final String name = "circle";
    private double circleRadius;

    public Circle(double circleRadius) {
        this.circleRadius = circleRadius;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        return Math.PI * Math.pow(circleRadius,2);
    }

    @Override
    public String toString() {
        return "name=" + name;
    }

}
