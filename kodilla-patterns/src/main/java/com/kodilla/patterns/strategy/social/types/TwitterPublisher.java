package com.kodilla.patterns.strategy.social.types;

import com.kodilla.patterns.strategy.social.SocialPublisher;

public class TwitterPublisher implements SocialPublisher {
    @Override
    public String share() {
        return "[Twitter] your favourite social media channel is Twitter";
    }
}
