package com.kodilla.good.patterns.challenges.tasktwo.data;

import com.kodilla.good.patterns.challenges.tasktwo.repository.OrderDaoRepository;

public class OrderDao implements OrderDaoRepository {
    @Override
    public void createOrder(User user, Product product) {
        System.out.println("------------");
        System.out.println("User: " + user.getEmail());
        System.out.println("Product: " + product.getName());
        System.out.println("Category: " + product.getCategory());
        System.out.println("Price: " + product.getPrice());
    }
}
