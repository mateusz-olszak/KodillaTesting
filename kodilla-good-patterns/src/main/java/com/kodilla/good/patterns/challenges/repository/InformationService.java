package com.kodilla.good.patterns.challenges.repository;

import com.kodilla.good.patterns.challenges.data.Product;
import com.kodilla.good.patterns.challenges.data.User;

public interface InformationService {
    void inform(User user, Product product);
}
