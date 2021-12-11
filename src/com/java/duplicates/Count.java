package com.java.duplicates;

import java.util.Map;

/**
 * created with love by mundiaem
 * created on 11/12/2021
 * Time: 14:27
 * ⚡  - CreditScoreAnalysis
 */

public class Count {
    String customer_id;
    int number_of_occurrence;

    Count(String customer_id, int number_of_occurrence) {
        this.customer_id = customer_id;
        this.number_of_occurrence = number_of_occurrence;

    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public void incrementNumberOfOccurrence() {
        this.number_of_occurrence++;
    }

    public int getNumber_of_occurrence() {
        return number_of_occurrence;
    }

    public void setNumber_of_occurrence(int number_of_occurrence) {
        this.number_of_occurrence = number_of_occurrence;
    }


}
