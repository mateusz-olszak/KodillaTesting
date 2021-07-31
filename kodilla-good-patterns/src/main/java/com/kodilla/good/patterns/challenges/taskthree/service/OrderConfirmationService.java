package com.kodilla.good.patterns.challenges.taskthree.service;

import com.kodilla.good.patterns.challenges.taskthree.data.Order;
import com.kodilla.good.patterns.challenges.taskthree.repository.ShipmentRepository;

public class OrderConfirmationService implements ShipmentRepository {
    @Override
    public boolean process(Order order) {
        System.out.println("The supplier: " + order.getSupplier().getName() + " has accepted your order. Order of product: " + order.getProduct().getName() + ", quantity: " + order.getQuantity() + ", totalPrice: " + order.getTotalPrice());

        return true;
    }
}
