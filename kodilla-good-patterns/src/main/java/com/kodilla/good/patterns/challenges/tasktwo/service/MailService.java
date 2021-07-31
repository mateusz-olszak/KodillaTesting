package com.kodilla.good.patterns.challenges.tasktwo.service;

import com.kodilla.good.patterns.challenges.tasktwo.repository.InformationRepository;
import com.kodilla.good.patterns.challenges.tasktwo.data.Product;
import com.kodilla.good.patterns.challenges.tasktwo.data.User;

public class MailService implements InformationRepository {
    @Override
    public void inform(User user, Product product) {
        System.out.println("Your order was successfully completed. Your order: " + product.getName() + ", price: " + product.getPrice());
    }
}
