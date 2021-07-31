package com.kodilla.good.patterns.challenges;

import com.kodilla.good.patterns.challenges.taskthree.data.Order;
import com.kodilla.good.patterns.challenges.taskthree.service.*;
import com.kodilla.good.patterns.challenges.tasktwo.data.OrderDao;
import com.kodilla.good.patterns.challenges.tasktwo.data.OrderRequest;
import com.kodilla.good.patterns.challenges.tasktwo.service.MailService;
import com.kodilla.good.patterns.challenges.tasktwo.service.OrderService;
import com.kodilla.good.patterns.challenges.tasktwo.service.ProductOrderService;

public class MainSolid {
    public static void main(String[] args) {
///////   Task 13.2
//        DataRetrieverService dataRetrieverService = new DataRetrieverService();
//        OrderRequest orderRequest = dataRetrieverService.retrieve();
//
//        ProductOrderService orderProcessor = new ProductOrderService(new MailService(), new OrderService(), new OrderDao());
//        orderProcessor.process(orderRequest);

        DataRetrieverService dataRetrieverService = new DataRetrieverService();
        Order orderRequest = dataRetrieverService.retrieve();

        OrderProcessService orderProcessService = new OrderProcessService(new PdfFilePrinterService(), new OrderConfirmationService(), new SupplierDaoService());
        orderProcessService.process(orderRequest);
    }
}
