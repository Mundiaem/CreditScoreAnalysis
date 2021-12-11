package com.java.duplicates;

import java.util.Date;

/**
 * created with love by mundiaem
 * created on 11/12/2021
 * Time: 13:44
 * ⚡  - CreditScoreAnalysis
 */

public class Transactions {
    private String customer_id;
    private String transaction_amount;
    private Date transaction_date;

    public Transactions(String customer_id, String transaction_amount, Date transaction_date) {
        this.customer_id = customer_id;
        this.transaction_amount = transaction_amount;
        this.transaction_date = transaction_date;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getTransaction_amount() {
        return transaction_amount;
    }

    public void setTransaction_amount(String transaction_amount) {
        this.transaction_amount = transaction_amount;
    }

    public Date getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(Date transaction_date) {
        this.transaction_date = transaction_date;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "customer_id='" + customer_id + '\'' +
                ", transaction_amount='" + transaction_amount + '\'' +
                ",\n transaction_date='" + transaction_date + '\'' +
                '}';
    }
}
