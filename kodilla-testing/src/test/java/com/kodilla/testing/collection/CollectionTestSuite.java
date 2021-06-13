package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@DisplayName("Collection Test Suite")
public class CollectionTestSuite {

    private OddNumbersExterminator exterminator = new OddNumbersExterminator();

    @BeforeEach
    void beforeEach(){
        System.out.println("Test Unit: begin");
    }

    @AfterEach
    void afterEach(){
        System.out.println("Test Unit: end");
    }

    @DisplayName("Check how exterminate method behaves when the list is empty")
    @Test
    void testOddNumbersExterminatorEmptyList(){
        List<Integer> numbers = exterminator.exterminate(Arrays.asList());

        Assertions.assertEquals(numbers, numbers);
        System.out.println("Empty List: " + numbers);

    }

    @DisplayName("Check how exterminate method behaves when the list is filled")
    @Test
    void testOddNumbersExterminatorNormalList(){
        List<Integer> numbers = exterminator.exterminate(Arrays.asList(1,2,3,4,5,6,7,8,9,10));

        Assertions.assertEquals(Arrays.asList(2,4,6,8,10), numbers);
        System.out.println("Filled List: " + numbers);
    }

}
