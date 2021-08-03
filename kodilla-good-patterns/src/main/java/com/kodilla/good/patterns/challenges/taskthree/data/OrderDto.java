package com.kodilla.good.patterns.challenges.taskthree.data;

import com.kodilla.good.patterns.challenges.taskthree.repository.OrderProcessorRepository;

public class OrderDto {
    private final OrderProcessorRepository supplier;
    private final Order order;
    private final boolean isAccepted;


    public OrderDto(final OrderProcessorRepository supplier, final Order order, final boolean isAccepted) {
        this.supplier = supplier;
        this.order = order;
        this.isAccepted = isAccepted;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "supplier=" + supplier +
                ", order=" + order +
                ", isAccepted=" + isAccepted +
                '}';
    }
}
