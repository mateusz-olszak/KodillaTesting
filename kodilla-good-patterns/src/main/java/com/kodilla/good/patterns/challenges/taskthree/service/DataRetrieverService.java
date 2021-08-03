package com.kodilla.good.patterns.challenges.taskthree.service;

import com.kodilla.good.patterns.challenges.taskthree.data.Order;
import com.kodilla.good.patterns.challenges.taskthree.data.Product;
import com.kodilla.good.patterns.challenges.taskthree.suppliers.ExtraFoodShop;
import com.kodilla.good.patterns.challenges.taskthree.suppliers.HealthyShop;

public class DataRetrieverService {
    public Order retrieve(){
        Product product = new Product("grass", 9.99);

        return new Order(product, new HealthyShop(),100);
    }
}
