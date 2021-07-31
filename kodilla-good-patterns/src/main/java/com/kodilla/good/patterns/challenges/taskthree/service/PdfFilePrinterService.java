package com.kodilla.good.patterns.challenges.taskthree.service;

import com.kodilla.good.patterns.challenges.taskthree.data.Order;
import com.kodilla.good.patterns.challenges.taskthree.repository.InformationService;

public class PdfFilePrinterService implements InformationService {
    @Override
    public void printConfirmation(Order order) {
        System.out.println("Your order: " + order.toString() + " is being printed in pdf file");
    }
}
