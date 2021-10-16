package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;
import java.util.List;

public class PizzaNeapolitanianDecorator extends AbstractPizzaDecorator {
    public PizzaNeapolitanianDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(10));
    }

    @Override
    public List<String> getIngredients() {
        List<String> ingredients = super.getIngredients();
        ingredients.add("Mozzarella Cheese");
        ingredients.add("Olive Oil");
        ingredients.add("Fresh Basil");
        ingredients.add("Fresh Tomatos");
        return ingredients;
    }
}
