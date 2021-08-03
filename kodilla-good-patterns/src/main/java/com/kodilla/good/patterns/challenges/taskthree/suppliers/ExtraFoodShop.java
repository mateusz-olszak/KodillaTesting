package com.kodilla.good.patterns.challenges.taskthree.suppliers;

import com.kodilla.good.patterns.challenges.taskthree.data.Order;
import com.kodilla.good.patterns.challenges.taskthree.repository.OrderProcessorRepository;

import java.util.ArrayList;
import java.util.List;

public class ExtraFoodShop implements OrderProcessorRepository {

    private final List<String> productsList = new ArrayList<>();

    public ExtraFoodShop() {
        productsList.add("grass");
    }

    @Override
    public String toString() {
        return "ExtraFoodShop";
    }

    @Override
    public boolean process(Order order) {
        String productName = order.getProduct().getName();

        return productsList.contains(productName);
    }
}
