package com.kodilla.good.patterns.challenges.taskthree.service;

import com.kodilla.good.patterns.challenges.taskthree.data.Order;
import com.kodilla.good.patterns.challenges.taskthree.data.Product;
import com.kodilla.good.patterns.challenges.taskthree.data.Supplier;

public class DataRetrieverService {
    public Order retrieve(){
        Product product = new Product("grass", 9.99);
        Supplier supplier = new Supplier("NoFoodAfter6pm");

        return new Order(product,supplier,100);
    }
}
