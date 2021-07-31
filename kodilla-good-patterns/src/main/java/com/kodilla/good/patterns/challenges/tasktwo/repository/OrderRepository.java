package com.kodilla.good.patterns.challenges.tasktwo.repository;

import com.kodilla.good.patterns.challenges.tasktwo.data.Product;
import com.kodilla.good.patterns.challenges.tasktwo.data.User;

public interface OrderRepository {
    boolean makeOrder(final User user, final Product product);
}
