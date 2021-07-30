package com.kodilla.good.patterns.challenges.service;

import com.kodilla.good.patterns.challenges.repository.OrderRepository;
import com.kodilla.good.patterns.challenges.data.Product;
import com.kodilla.good.patterns.challenges.data.User;

public class OrderService implements OrderRepository {
    @Override
    public boolean makeOrder(User user, Product product) {
        System.out.println("Order for user: " + user.getEmail() + ", product: " + product.getName() + ", price: " + product.getPrice());
        return true;
    }
}
