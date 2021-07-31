package com.kodilla.good.patterns.challenges.tasktwo.repository;

import com.kodilla.good.patterns.challenges.tasktwo.data.Product;
import com.kodilla.good.patterns.challenges.tasktwo.data.User;

public interface OrderDaoRepository {
    void createOrder(User user, Product product);
}
