package com.kodilla.patterns.strategy.social.users;

import com.kodilla.patterns.strategy.social.types.SnapchatPublisher;

public class ZGeneration extends User {

    public ZGeneration(String username) {
        super(username);
        this.socialPublisher = new SnapchatPublisher();
    }
}
