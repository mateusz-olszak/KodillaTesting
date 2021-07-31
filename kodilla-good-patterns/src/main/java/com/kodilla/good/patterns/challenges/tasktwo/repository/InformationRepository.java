package com.kodilla.good.patterns.challenges.tasktwo.repository;

import com.kodilla.good.patterns.challenges.tasktwo.data.Product;
import com.kodilla.good.patterns.challenges.tasktwo.data.User;

public interface InformationRepository {
    void inform(User user, Product product);
}
