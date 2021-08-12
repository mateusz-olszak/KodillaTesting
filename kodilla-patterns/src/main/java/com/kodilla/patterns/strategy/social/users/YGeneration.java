package com.kodilla.patterns.strategy.social.users;

import com.kodilla.patterns.strategy.social.types.FacebookPublisher;

public class YGeneration extends User {

    public YGeneration(String username) {
        super(username);
        this.socialPublisher = new FacebookPublisher();
    }
}
