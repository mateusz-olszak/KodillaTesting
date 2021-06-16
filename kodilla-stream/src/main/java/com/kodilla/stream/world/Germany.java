package com.kodilla.stream.world;

import java.math.BigDecimal;

public final class Germany implements Country {
    @Override
    public BigDecimal getPeopleQuantity() {
        return new BigDecimal("83000000");
    }
}
