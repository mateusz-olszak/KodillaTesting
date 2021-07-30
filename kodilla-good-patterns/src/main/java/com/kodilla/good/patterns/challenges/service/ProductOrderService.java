package com.kodilla.good.patterns.challenges.service;

import com.kodilla.good.patterns.challenges.data.OrderDto;
import com.kodilla.good.patterns.challenges.data.OrderRequest;
import com.kodilla.good.patterns.challenges.repository.MailRepository;
import com.kodilla.good.patterns.challenges.repository.OrderDaoRepository;
import com.kodilla.good.patterns.challenges.repository.OrderRepository;

public class ProductOrderService {
    private MailRepository informationService;
    private OrderRepository orderRepository;
    private OrderDaoRepository orderDaoRepository;

    public ProductOrderService(MailRepository informationService, OrderRepository orderRepository, OrderDaoRepository orderDaoRepository) {
        this.informationService = informationService;
        this.orderRepository = orderRepository;
        this.orderDaoRepository = orderDaoRepository;
    }


    public OrderDto process(final OrderRequest orderRequest){
        boolean isOrdered = orderRepository.makeOrder(orderRequest.getUser(), orderRequest.getProduct());

        if (isOrdered){
            informationService.sendMail(orderRequest.getUser(),orderRequest.getProduct());
            orderDaoRepository.createOrder(orderRequest.getUser(), orderRequest.getProduct());
            return new OrderDto(orderRequest.getUser(), orderRequest.getProduct(), true);
        }else {
            return new OrderDto(orderRequest.getUser(), orderRequest.getProduct(), false);
        }
    }

}