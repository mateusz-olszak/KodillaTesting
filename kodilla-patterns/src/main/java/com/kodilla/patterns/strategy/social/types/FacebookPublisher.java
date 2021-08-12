package com.kodilla.patterns.strategy.social.types;

import com.kodilla.patterns.strategy.social.SocialPublisher;

public class FacebookPublisher implements SocialPublisher {
    @Override
    public String share() {
        return "[Facebook] your favourite social media channel is Facebook";
    }
}
