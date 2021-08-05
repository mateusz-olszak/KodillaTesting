package com.kodilla.spring.intro.shape;

import org.junit.jupiter.api.Test;

public class DrawerTestSuite {

    @Test
    void testDoDrawingWithCircle(){
        Drawer drawer = new Drawer(new Circle());

        drawer.doDrawing();
    }

    @Test
    void testDoDrawingWithTriangle(){
        Drawer drawer = new Drawer(new Triangle());

        drawer.doDrawing();
    }

}
