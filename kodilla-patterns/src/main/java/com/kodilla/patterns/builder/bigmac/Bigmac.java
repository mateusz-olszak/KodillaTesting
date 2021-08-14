package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bigmac {


    private final Ingredients bun;
    private final Ingredients sauce;
    private final int burgers;
    private final List<Ingredients> ingredients;

    private Bigmac(Ingredients bun, Ingredients sauce, int burgers, List<Ingredients> ingredients) {
        this.bun = bun;
        this.sauce = sauce;
        this.burgers = burgers;
        this.ingredients = ingredients;
    }

    public static class BigmacBuilder{
        private Ingredients bun;
        private Ingredients sauce;
        private int burgers;
        private List<Ingredients> ingredients = new ArrayList<>();

        public BigmacBuilder bun(Ingredients bun){
            if (bun.equals(Ingredients.SESAME_BUN) || bun.equals(Ingredients.PLAIN_BUN))
                this.bun = bun;
            else
                throw new IllegalStateException("This is not type of bun");

            return this;
        }

        public BigmacBuilder burger(int burger){
            if (burger >= 0 || burger <= 10)
                this.burgers = burger;
            else
                throw new IllegalStateException("Amount of burgers is invalid");

            return this;
        }

        public BigmacBuilder sauce(Ingredients sauce){
            if (sauce.equals(Ingredients.STANDARD_SAUCE) || sauce.equals(Ingredients.ISLAND_SAUCE) || sauce.equals(Ingredients.BARBECUE_SAUCE))
                this.sauce = sauce;
            else
                throw new IllegalStateException("Wrong value for sauce");

            return this;
        }

        public BigmacBuilder ingredient(Ingredients ingredient){
            List<Ingredients> ingredientsList = Arrays.asList(
                    Ingredients.BEKON,Ingredients.CHILI,
                    Ingredients.CHEESE,Ingredients.LETUCE,
                    Ingredients.PICKLE,Ingredients.MUSHROOMS,
                    Ingredients.ONION, Ingredients.PRAWNS);

            if (ingredientsList.contains(ingredient))
                this.ingredients.add(ingredient);
            else
                throw new IllegalStateException("Wrong ingredient");

            return this;
        }

        public Bigmac build(){
            return new Bigmac(bun,sauce,burgers,ingredients);
        }

    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "bun='" + bun.ingredient + '\'' +
                ", sauce='" + sauce.ingredient + '\'' +
                ", burgers=" + burgers +
                ", ingredients=" + ingredients +
                '}';
    }
}
