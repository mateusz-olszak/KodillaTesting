package com.kodilla.patterns.strategy.social.types;

import com.kodilla.patterns.strategy.social.SocialPublisher;

public class SnapchatPublisher implements SocialPublisher {
    @Override
    public String share() {
        return "[Snapchat] your favourite social media channel is Snapchat";
    }
}
