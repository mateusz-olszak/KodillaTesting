package com.kodilla.good.patterns.challenges.service;

import com.kodilla.good.patterns.challenges.repository.MailRepository;
import com.kodilla.good.patterns.challenges.data.Product;
import com.kodilla.good.patterns.challenges.data.User;

public class InformationService implements MailRepository {
    @Override
    public void sendMail(User user, Product product) {
        System.out.println("Your order was successfully completed. Your order: " + product.getName() + ", price: " + product.getPrice());
    }
}
