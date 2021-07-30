package com.kodilla.good.patterns.challenges.service;

import com.kodilla.good.patterns.challenges.data.Category;
import com.kodilla.good.patterns.challenges.data.OrderRequest;
import com.kodilla.good.patterns.challenges.data.Product;
import com.kodilla.good.patterns.challenges.data.User;

public class DataRetrieverService {
    public OrderRequest retrieve(){
        Category category = new Category("Furniture","This category contain everything to equip your house");
        Product product = new Product("Chair",99.99, "You can comfortably sit on it", category);
        User user = new User("kowalski@gmail.com");

        return new OrderRequest(user,product);
    }
}
