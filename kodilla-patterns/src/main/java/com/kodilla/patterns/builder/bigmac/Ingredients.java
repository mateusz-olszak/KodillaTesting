package com.kodilla.patterns.builder.bigmac;

public enum Ingredients {
    SESAME_BUN("SESAME"),
    PLAIN_BUN("PLAIN"),
    STANDARD_SAUCE("STANDARD"),
    ISLAND_SAUCE("1000ISLAND"),
    BARBECUE_SAUCE("BARBECUE"),
    LETUCE("LETUCE"),
    ONION("ONION"),
    BEKON("BEKON"),
    PICKLE("PICKLE"),
    CHILI("CHILI"),
    MUSHROOMS("MUSHROOMS"),
    PRAWNS("PRAWNS"),
    CHEESE("CHEESE");

    public String ingredient;

    Ingredients(String ingredient) {
        this.ingredient = ingredient;
    }
}
