package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;
import java.util.List;

public class PizzaCapricciosaDecorator extends AbstractPizzaDecorator {
    public PizzaCapricciosaDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(5));
    }

    @Override
    public List<String> getIngredients() {
        List<String> ingredients = super.getIngredients();
        ingredients.add("Mushrooms");
        ingredients.add("Ham");
        ingredients.add("Olive Oil");
        return ingredients;
    }
}
