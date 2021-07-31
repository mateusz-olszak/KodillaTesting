package com.kodilla.good.patterns.challenges.taskthree.data;

public class Order {

    private Product product;
    private Supplier supplier;
    private int quantity;

    public Order(Product product, Supplier supplier, int quantity) {
        this.product = product;
        this.supplier = supplier;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotalPrice(){
        return quantity*(int)product.getPrice();
    }

    @Override
    public String toString() {
        return "Order{" +
                "product=" + product +
                ", supplier=" + supplier +
                ", quantity=" + quantity +
                '}';
    }
}
