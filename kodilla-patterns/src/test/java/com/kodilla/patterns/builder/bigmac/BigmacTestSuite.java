package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

public class BigmacTestSuite {

    @Test
    void testBuildBigmac(){
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun(Ingredients.SESAME_BUN)
                .burger(2)
                .sauce(Ingredients.ISLAND_SAUCE)
                .ingredient(Ingredients.BEKON)
                .ingredient(Ingredients.CHEESE)
                .build();

        System.out.println(bigmac);
    }

}
