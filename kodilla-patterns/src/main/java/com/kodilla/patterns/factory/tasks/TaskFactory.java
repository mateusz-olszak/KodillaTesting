package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public static final String SHOPPING = "SHOPPING";
    public static final String DRIVING = "DRIVING";
    public static final String PAINTING = "PAINTING";

    public final Task makeTask(final String task){
        switch (task){
            case SHOPPING:
                return new ShoppingTask("GoShopping","snacks",5);
            case DRIVING:
                return new DrivingTask("GoDriving","Wroclaw","car");
            case PAINTING:
                return new PaintingTask("GoPainting","red","painting");
            default:
                return null;
        }
    }

}
