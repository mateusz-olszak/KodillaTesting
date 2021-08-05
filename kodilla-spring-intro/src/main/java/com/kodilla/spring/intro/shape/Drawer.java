package com.kodilla.spring.intro.shape;

public class Drawer {

    private final Shape shape;

    public Drawer(final Shape shape) {
        this.shape = shape;
    }

    public void doDrawing(){
        System.out.println(shape.draw());
    }
}
