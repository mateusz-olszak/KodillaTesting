package com.kodilla.good.patterns.challenges.taskthree.service;

import com.kodilla.good.patterns.challenges.taskthree.data.Order;
import com.kodilla.good.patterns.challenges.taskthree.data.OrderDto;
import com.kodilla.good.patterns.challenges.taskthree.repository.InformationService;
import com.kodilla.good.patterns.challenges.taskthree.repository.OrderDaoRepository;

public class OrderProcessorService {

    private final InformationService informationService;
    private final OrderDaoRepository orderDaoRepository;

    public OrderProcessorService(final InformationService informationService,final OrderDaoRepository orderDaoRepository) {
        this.informationService = informationService;
        this.orderDaoRepository = orderDaoRepository;
    }

    public OrderDto makeOrder(Order order){
        boolean isAccepted = order.getSupplier().process(order);

        if (isAccepted){
            informationService.printConfirmation(order);
            orderDaoRepository.saveOrder(order);
            return new OrderDto(order.getSupplier(), order, true);
        }else{
            return new OrderDto(order.getSupplier(), order, false);
        }
    }

}
