package com.kodilla.testing.shape;

public class Triangle implements Shape {

    private final String name = "triangle";
    private double traingleSide;
    private double triangleHeight;

    public Triangle(double traingleSide, double triangleHeight) {
        this.traingleSide = traingleSide;
        this.triangleHeight = triangleHeight;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        return (traingleSide*triangleHeight)/2;
    }

    @Override
    public String toString() {
        return "name=" + name;
    }
}
