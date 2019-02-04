package com.servicenow.assignment.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class ProductTest {

    @Test
    public void shouldGetProductTotalAmount() {

        Product product = new Product("Test");
        Transaction transaction1 = new Transaction(new Date(), 23452);
        Transaction transaction2 = new Transaction(new Date(), 453556);
        product.addTransaction(transaction1);
        product.addTransaction(transaction2);
        double expected = 477008;
        double actual = product.getTotalProductAmount();

        Assert.assertEquals(expected, actual,0);

    }
}
