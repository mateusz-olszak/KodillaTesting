package com.kodilla.good.patterns.challenges.taskthree.service;

import com.kodilla.good.patterns.challenges.taskthree.data.Order;
import com.kodilla.good.patterns.challenges.taskthree.repository.SupplierDaoRepository;

public class SupplierDaoService implements SupplierDaoRepository {
    @Override
    public void saveOrder(Order order) {
        System.out.println("------------");
        System.out.println("Supplier: " + order.getSupplier().getName());
        System.out.println("Product: " + order.getProduct().getName());
        System.out.println("Quantity: " + order.getQuantity());
        System.out.println("Total Price: " + order.getTotalPrice());
    }
}
