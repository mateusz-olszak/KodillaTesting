package com.kodilla.good.patterns.challenges.tasktwo.service;

import com.kodilla.good.patterns.challenges.tasktwo.data.OrderDto;
import com.kodilla.good.patterns.challenges.tasktwo.data.OrderRequest;
import com.kodilla.good.patterns.challenges.tasktwo.repository.InformationRepository;
import com.kodilla.good.patterns.challenges.tasktwo.repository.OrderDaoRepository;
import com.kodilla.good.patterns.challenges.tasktwo.repository.OrderRepository;

public class ProductOrderService {
    private InformationRepository informationRepository;
    private OrderRepository orderRepository;
    private OrderDaoRepository orderDaoRepository;

    public ProductOrderService(InformationRepository informationService, OrderRepository orderRepository, OrderDaoRepository orderDaoRepository) {
        this.informationRepository = informationService;
        this.orderRepository = orderRepository;
        this.orderDaoRepository = orderDaoRepository;
    }


    public OrderDto process(final OrderRequest orderRequest){
        boolean isOrdered = orderRepository.makeOrder(orderRequest.getUser(), orderRequest.getProduct());

        if (isOrdered){
            informationRepository.inform(orderRequest.getUser(),orderRequest.getProduct());
            orderDaoRepository.createOrder(orderRequest.getUser(), orderRequest.getProduct());
            return new OrderDto(orderRequest.getUser(), orderRequest.getProduct(), true);
        }else {
            return new OrderDto(orderRequest.getUser(), orderRequest.getProduct(), false);
        }
    }

}