package com.java.duplicates;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    /*
     * 1. Read data from csv file
     * 2. sort the data according to dates
     * 3. get most transaction per customer
     * 4. sort in natural order for customer ids
     * 5. sort in reverse order for values*/
    public static void main(String[] args) {
        // write your code here
        String transaction_csv_file_path = "src/interview_code_test/test_data/transaction_data_1.csv";
        String transaction_csv_file_path_1 = "src/interview_code_test/test_data/transaction_data_2.csv";
        String transaction_csv_file_path_2 = "src/interview_code_test/test_data/transaction_data_3.csv";
        getsBestCreditScore(transaction_csv_file_path, 1);
        getsBestCreditScore(transaction_csv_file_path_1, 3);
        getsBestCreditScore(transaction_csv_file_path_2, 5);


    }

    // method for reading the data from csv
    private static void getsBestCreditScore(String transaction_csv_file_path, int n) {
        String data = "";
        String[] transactions = {};
        int count = 0;
        int index = 0;
        List<Transactions> transactionsList = new ArrayList<>();
        Date transaction_date = null;

        try {
            Scanner scv_reader = new Scanner(new File(transaction_csv_file_path));
            scv_reader.useDelimiter(",");
            BufferedReader mBufferReader = new BufferedReader(new FileReader(transaction_csv_file_path));
            while ((data = mBufferReader.readLine()) != null) {
                transactions = data.split(",");
                if (count > 0) {
                    try {
                        transaction_date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(transactions[2]);
//                        System.out.println(transaction_date);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    transactionsList.add(new Transactions(transactions[0], transaction_date));

                }
                count++;


            }

            scv_reader.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> customers = mostTransactionPerCustomer(sortTransactionDates(transactionsList), n);

        StringBuffer output = new StringBuffer(110);
        output.append("[ ");
        int _count = 0;
        Iterator<String> stringIterator = customers.stream().limit(n).iterator();
        while (stringIterator.hasNext()) {
            if (_count == 0) {
                output.append(String.format("'%s' ", stringIterator.next()));
            } else {
                _count++;
                output.append(String.format("'%s' ", stringIterator.next()));
            }

        }
        String joinedString = String.join(",", output);
        String.join("''", customers);
        System.out.println(joinedString + "]");

    }

    // sorting the transaction dates to descending order
    private static List<Transactions> sortTransactionDates(List<Transactions> transactions) {
        transactions.sort(Comparator.comparing(Transactions::getTransaction_date));
//        System.out.printf(" Sorted :: %s ", transactions);
        return transactions;
    }

    private static List<String> mostTransactionPerCustomer(List<Transactions> transactions, int n) {
        List<String>
                customers = new ArrayList<>();

        Map<String, Integer> storeCustomerTransactionCount = new HashMap<>();
        List<Transactions> myCustomers = new ArrayList<>();


        int transSize = transactions.size();
        for (int i = 0; i < transSize - 1; i++) {


            if (transactions.get(i).getCustomer_id().equalsIgnoreCase(transactions.get(i + 1).getCustomer_id())) {
                myCustomers.add(transactions.get(i));

            }
        }

        int cssz = myCustomers.size();
        for (int k = 0; k < cssz - 1; k++) {
            if (myCustomers.get(k).getCustomer_id().equalsIgnoreCase(myCustomers.get(k + 1).getCustomer_id())) {
                if (!storeCustomerTransactionCount.containsKey(transactions.get(k).getCustomer_id())) {
                    storeCustomerTransactionCount.put(transactions.get(k).getCustomer_id(), 1);
                } else {
                    int value = storeCustomerTransactionCount.get(transactions.get(k).getCustomer_id());
                    value++;
                    storeCustomerTransactionCount.put(transactions.get(k).getCustomer_id(), value);

                }
            }

        }
//        System.out.println(storeCustomerTransactionCount.toString());


        LinkedHashMap<String, Integer> sortedCustomers = new LinkedHashMap<>();
        storeCustomerTransactionCount.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.naturalOrder())).sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> sortedCustomers.put(x.getKey(), x.getValue()));
//        System.out.println(sortedCustomers.toString());


        for (Map.Entry<String, Integer> mapCustomers : sortedCustomers.entrySet()) {
            customers.add(mapCustomers.getKey());
        }


        return customers;

    }
}
