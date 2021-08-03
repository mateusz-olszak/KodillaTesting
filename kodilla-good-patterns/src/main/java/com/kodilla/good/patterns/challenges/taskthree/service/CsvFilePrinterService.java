package com.kodilla.good.patterns.challenges.taskthree.service;

import com.kodilla.good.patterns.challenges.taskthree.data.Order;
import com.kodilla.good.patterns.challenges.taskthree.repository.InformationService;

public class CsvFilePrinterService implements InformationService {
    @Override
    public void printConfirmation(Order order) {
        System.out.println("Your order info: " + order.toString() + " is being printed in csv file");
    }
}
