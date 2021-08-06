package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    @Test
    void testCalculations(){
        double add;
        double sub;
        double mul;
        double div;

        add = calculator.add(5,5);
        sub = calculator.sub(5,5);
        mul = calculator.mul(5,5);
        div = calculator.div(5,5);

        assertEquals(10.0,add);
        assertEquals(0.0,sub);
        assertEquals(25.0,mul);
        assertEquals(1.0,div);
    }

}
