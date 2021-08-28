package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class InoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    void testInvoiceDaoSave(){
        Invoice invoice = new Invoice("IV/176/2017");
        Invoice invoice2 = new Invoice("IV/177/2017");
        Invoice invoice3 = new Invoice("IV/178/2017");
        Product product = new Product("Pen");
        Product product2 = new Product("Rubber");
        Product product3 = new Product("Pencil");
        Item item = new Item(new BigDecimal(3),4,new BigDecimal(12));
        Item item2 = new Item(new BigDecimal(1),1,new BigDecimal(1));
        Item item3 = new Item(new BigDecimal(5),3,new BigDecimal(15));

        item.getProducts().add(product3);
        item2.getProducts().add(product2);
        item3.getProducts().add(product);

        product.setItem(item3);
        product2.setItem(item2);
        product3.setItem(item);

        item.setInvoice(invoice);
        item2.setInvoice(invoice2);
        item3.setInvoice(invoice3);
        invoice.getItems().add(item);
        invoice2.getItems().add(item2);
        invoice3.getItems().add(item3);

        invoiceDao.save(invoice);
        invoiceDao.save(invoice2);
        invoiceDao.save(invoice3);

        int invoiceId = invoice.getId();
        int invoice2Id = invoice2.getId();
        int invoice3Id = invoice3.getId();

        invoiceDao.deleteById(invoiceId);
        invoiceDao.deleteById(invoice2Id);
        invoiceDao.deleteById(invoice3Id);
    }

}
