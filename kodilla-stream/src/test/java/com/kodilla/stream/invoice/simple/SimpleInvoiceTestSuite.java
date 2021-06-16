package com.kodilla.stream.invoice.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleInvoiceTestSuite {

    @Test
    public void testGetValueToPay(){
        SimpleInvoice invoice = new SimpleInvoice();
        invoice.addItem(new SimpleItem(new SimpleProduct("krzeslo",99.99),4.0));
        invoice.addItem(new SimpleItem(new SimpleProduct("biurko",199.0),1.0));
        invoice.addItem(new SimpleItem(new SimpleProduct("komoda",499.0),2.0));
        invoice.addItem(new SimpleItem(new SimpleProduct("lampka",39.58),5.0));

        double totalPrice = invoice.getValueToPay();

        Assertions.assertEquals(1794.86, totalPrice,0);
    }

}
