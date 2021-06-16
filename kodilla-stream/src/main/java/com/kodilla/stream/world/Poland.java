package com.kodilla.stream.world;

import java.math.BigDecimal;

public final class Poland implements Country {
    @Override
    public BigDecimal getPeopleQuantity() {
        return new BigDecimal("38000000");
    }
}
