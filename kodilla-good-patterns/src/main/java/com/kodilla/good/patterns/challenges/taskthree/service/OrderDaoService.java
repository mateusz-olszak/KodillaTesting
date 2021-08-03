package com.kodilla.good.patterns.challenges.taskthree.service;

import com.kodilla.good.patterns.challenges.taskthree.data.Order;
import com.kodilla.good.patterns.challenges.taskthree.repository.OrderDaoRepository;

public class OrderDaoService implements OrderDaoRepository {
    @Override
    public void saveOrder(Order order) {
        System.out.println("Order saved to database");
    }
}
