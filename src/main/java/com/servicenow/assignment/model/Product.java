package com.servicenow.assignment.model;

import java.util.ArrayList;
import java.util.List;

/***
 * Product Class
 */
public class Product {
    private String productName;
    private List<Transaction> transactionList;

    public Product(String productName) {
        this.productName = productName;
        this.transactionList = new ArrayList();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void addTransaction(Transaction transactionList) {
        this.transactionList.add(transactionList);
    }

    public double getTotalProductAmount() {
        double amount = 0;
        for (Transaction transaction : transactionList) {
            amount += transaction.getAmount();
        }
        return amount;
    }
}
