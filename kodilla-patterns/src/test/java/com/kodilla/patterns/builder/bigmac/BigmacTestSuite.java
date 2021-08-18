package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class BigmacTestSuite {

    @Test
    void testBuildBigmacWithRightIngredients(){
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun(Ingredients.SESAME_BUN)
                .burger(2)
                .sauce(Ingredients.ISLAND_SAUCE)
                .ingredient(Ingredients.BEKON)
                .ingredient(Ingredients.CHEESE)
                .build();

        int ingredientsAmount = bigmac.getIngredients().size();

        assertEquals(2,ingredientsAmount);
    }

    @Test
    void testBuildBigmacWithWrongIngredients(){
//        Exception exception = assertThrows(IllegalStateException.class, new Executable() {
//            @Override
//            public void execute() throws Throwable {
//
//            }
//        });

//        String expectedMessage = "Wrong value for sauce";
//        String actualMessage = exception.getMessage();

//        assertTrue(actualMessage.contains(expectedMessage));

        assertThrows(IllegalStateException.class,() -> {
            Bigmac bigmac = new Bigmac.BigmacBuilder()
                    .bun(Ingredients.SESAME_BUN)
                    .burger(3)
                    .sauce(Ingredients.BEKON)
                    .ingredient(Ingredients.ONION)
                    .build();
        });
    }

}
