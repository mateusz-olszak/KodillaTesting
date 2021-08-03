package com.kodilla.good.patterns.challenges;

import com.kodilla.good.patterns.challenges.taskfour.data.FlightDto;
import com.kodilla.good.patterns.challenges.taskfour.service.*;
import com.kodilla.good.patterns.challenges.taskthree.data.Order;
import com.kodilla.good.patterns.challenges.taskthree.data.OrderDto;
import com.kodilla.good.patterns.challenges.taskthree.service.*;

public class MainSolid {
    public static void main(String[] args) {
///////   Task 13.2
//        DataRetrieverService dataRetrieverService = new DataRetrieverService();
//        OrderRequest orderRequest = dataRetrieverService.retrieve();
//
//        ProductOrderService orderProcessor = new ProductOrderService(new MailService(), new OrderService(), new OrderDao());
//        orderProcessor.process(orderRequest);

        /// Task 13.3
        DataRetrieverService dataRetrieverService = new DataRetrieverService();
        Order orderRequest = dataRetrieverService.retrieve();

        OrderProcessorService processorService = new OrderProcessorService(new PdfFilePrinterService(), new OrderDaoService());
        OrderDto orderDto = processorService.makeOrder(orderRequest);
        System.out.println(orderDto);

        /// Task 13.4
//        FlightDataRetrieverService flightDataRetriever = new FlightDataRetrieverService();
//        FlightDto flight = flightDataRetriever.retrieve();
//
//        FlightFinderProcessorService finderProcessorServiceFrom = new FlightFinderProcessorService(new FlightFinderService());
//        finderProcessorServiceFrom.process(flight);

    }
}
