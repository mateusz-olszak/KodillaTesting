package com.kodilla.good.patterns.challenges.tasktwo.data;

public class OrderDto {
    private User user;
    private Product product;
    private boolean isOrdered;

    public OrderDto(User user, Product product, boolean isOrdered) {
        this.user = user;
        this.product = product;
        this.isOrdered = isOrdered;
    }
}
