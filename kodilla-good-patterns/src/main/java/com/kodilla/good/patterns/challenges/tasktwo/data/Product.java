package com.kodilla.good.patterns.challenges.tasktwo.data;

import java.math.BigDecimal;

public class Product {

    private final String name;
    private final BigDecimal price;
    private final String desription;
    private final Category category;

    public Product(final String name, final double price, final String desription, final Category category) {
        this.name = name;
        this.price = new BigDecimal(String.valueOf(price));
        this.desription = desription;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDesription() {
        return desription;
    }

    public Category getCategory() {
        return category;
    }
}
