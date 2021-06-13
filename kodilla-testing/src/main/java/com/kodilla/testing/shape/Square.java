package com.kodilla.testing.shape;

public class Square implements Shape {

    private final String name = "square";
    private double squareSide;

    public Square(double squareSide) {
        this.squareSide = squareSide;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        return Math.pow(squareSide,2);
    }

    @Override
    public String toString() {
        return "name=" + name;
    }
}
