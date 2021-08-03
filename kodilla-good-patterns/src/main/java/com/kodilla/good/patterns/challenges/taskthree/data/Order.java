package com.kodilla.good.patterns.challenges.taskthree.data;

import com.kodilla.good.patterns.challenges.taskthree.repository.OrderProcessorRepository;

public class Order {

    private Product product;
    private OrderProcessorRepository orderProcessorRepository;
    private int quantity;

    public Order(Product product, OrderProcessorRepository orderProcessorRepository, int quantity) {
        this.product = product;
        this.orderProcessorRepository = orderProcessorRepository;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public OrderProcessorRepository getSupplier() {
        return orderProcessorRepository;
    }

    @Override
    public String toString() {
        return "Order{" +
                "product=" + product +
                ", quantity=" + quantity +
                ", totalPrice=" + quantity*(int)product.getPrice() +
                '}';
    }
}
