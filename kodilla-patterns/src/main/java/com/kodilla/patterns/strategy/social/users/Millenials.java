package com.kodilla.patterns.strategy.social.users;

import com.kodilla.patterns.strategy.social.types.TwitterPublisher;

public class Millenials extends User {

    public Millenials(String username) {
        super(username);
        this.socialPublisher = new TwitterPublisher();
    }
}
