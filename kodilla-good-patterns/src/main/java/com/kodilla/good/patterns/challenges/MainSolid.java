package com.kodilla.good.patterns.challenges;

import com.kodilla.good.patterns.challenges.data.OrderDao;
import com.kodilla.good.patterns.challenges.data.OrderRequest;
import com.kodilla.good.patterns.challenges.service.DataRetrieverService;
import com.kodilla.good.patterns.challenges.service.MailService;
import com.kodilla.good.patterns.challenges.service.OrderService;
import com.kodilla.good.patterns.challenges.service.ProductOrderService;

public class MainSolid {
    public static void main(String[] args) {
        DataRetrieverService dataRetrieverService = new DataRetrieverService();
        OrderRequest orderRequest = dataRetrieverService.retrieve();

        ProductOrderService orderProcessor = new ProductOrderService(new MailService(), new OrderService(), new OrderDao());
        orderProcessor.process(orderRequest);

    }
}
