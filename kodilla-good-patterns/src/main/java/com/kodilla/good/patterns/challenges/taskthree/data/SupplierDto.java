package com.kodilla.good.patterns.challenges.taskthree.data;

public class SupplierDto {
    private final Supplier supplier;
    private final Order order;
    private final boolean isAccepted;


    public SupplierDto(final Supplier supplier,final Order order,final boolean isAccepted) {
        this.supplier = supplier;
        this.order = order;
        this.isAccepted = isAccepted;
    }
}
