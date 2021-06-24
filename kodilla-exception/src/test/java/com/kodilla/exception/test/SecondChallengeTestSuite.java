package com.kodilla.exception.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class SecondChallengeTestSuite {

    @Test
    public void testProbablyIWillThrowException(){
        ExceptionHandling handler = new ExceptionHandling();

        assertAll(
                () -> assertThrows(Exception.class, () -> handler.handleMethod(2.0,1.4)),
                () ->  assertThrows(Exception.class, () -> handler.handleMethod(1,1.5)),
                () ->  assertThrows(Exception.class, () -> handler.handleMethod(0.9,1.6)),
                () ->  assertDoesNotThrow(() -> handler.handleMethod(1.5,1.0))
        );
    }

}
