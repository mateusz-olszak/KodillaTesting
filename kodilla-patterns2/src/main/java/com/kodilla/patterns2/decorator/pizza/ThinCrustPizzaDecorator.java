package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;
import java.util.List;

public class ThinCrustPizzaDecorator extends AbstractPizzaDecorator {
    public ThinCrustPizzaDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost();
    }

    @Override
    public List<String> getIngredients() {
        List<String> ingredients = super.getIngredients();
        ingredients.removeIf(dough -> dough.equals("Fat dough"));
        ingredients.add("Thin dough");
        return ingredients;
    }
}
