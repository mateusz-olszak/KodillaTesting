package com.kodilla.stream.world;

import java.math.BigDecimal;

public final class France implements Country {
    @Override
    public BigDecimal getPeopleQuantity() {
        return new BigDecimal("67000000");
    }
}
