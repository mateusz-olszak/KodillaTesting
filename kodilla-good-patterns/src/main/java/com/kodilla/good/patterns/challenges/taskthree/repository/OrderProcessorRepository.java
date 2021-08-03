package com.kodilla.good.patterns.challenges.taskthree.repository;

import com.kodilla.good.patterns.challenges.taskthree.data.Order;

public interface OrderProcessorRepository {
    boolean process(Order order);
}
