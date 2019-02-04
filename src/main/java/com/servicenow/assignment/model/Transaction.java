package com.servicenow.assignment.model;

import java.util.Date;

/***
 * Transaction class
 */
public class Transaction {
    private Date transactionDate;
    private double amount;

    public Transaction(Date transactionDate, double amount) {
        this.transactionDate = transactionDate;
        this.amount = amount;
    }
    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
