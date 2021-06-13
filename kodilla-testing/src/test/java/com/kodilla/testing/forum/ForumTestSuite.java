package com.kodilla.testing.forum;

import com.kodilla.testing.calculator.Calculator;
import org.junit.jupiter.api.*;

@DisplayName("Forum Test Suite")
public class ForumTestSuite {

    @BeforeAll
    static void beforeAll(){
        System.out.println("Test Suite: begin");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("Test Suite: begin");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("Test Case: begin");
    }

    @AfterEach
    void afterEach(){
        System.out.println("Test Case: end");
    }


    @DisplayName(
            "When the method add is called" +
                    " it should return correct result"
    )
    @Test
    public void testAdditionResult(){
        Calculator calculator = new Calculator();

        int add = calculator.add(5,5);

        Assertions.assertEquals(10,add);

    }

    @DisplayName(
            "When the method subtract is called" +
                    " it should return correct result"
    )
    @Test
    public void testSubtractResult(){
        Calculator calculator = new Calculator();

        int substract = calculator.subtract(5,5);

        Assertions.assertEquals(0,substract);
    }

}
