package com.kodilla.good.patterns.challenges.tasktwo.service;

import com.kodilla.good.patterns.challenges.tasktwo.repository.OrderRepository;
import com.kodilla.good.patterns.challenges.tasktwo.data.Product;
import com.kodilla.good.patterns.challenges.tasktwo.data.User;

public class OrderService implements OrderRepository {
    @Override
    public boolean makeOrder(User user, Product product) {
        System.out.println("Order for user: " + user.getEmail() + ", product: " + product.getName() + ", price: " + product.getPrice());
        return true;
    }
}
