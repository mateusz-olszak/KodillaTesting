package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {

    @Test
    public void testGetAverage(){
        int[] numbers = {2,2,3,4,5,6,7,8,9,10,11,12,13,14,15,15,15,16,15,15};

        assertEquals(9.85, ArrayOperations.getAverage(numbers));
    }

}
