package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasicPizzaDelegat implements PizzaOrder {

    private List<String> ingredients = new ArrayList<>();

    public BasicPizzaDelegat() {
        ingredients.add("Fat dough");
        ingredients.add("Tomato sauce");
        ingredients.add("Cheese");
    }

    @Override
    public BigDecimal getCost() {
        return new BigDecimal(15);
    }

    @Override
    public List<String> getIngredients() {
        return ingredients;
    }
}
