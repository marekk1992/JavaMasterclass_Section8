package exercises.banking;

import java.util.ArrayList;

public class Customer {

    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name) {
        this.name = name;
        transactions = new ArrayList<Double>();
        transactions.add(1000.0);
    }

    public String getCustomerName() {
        return name;
    }

    public void addTransaction(double transaction) {
        transactions.add(transaction);
    }

    public void printCustomersTransactions() {
        System.out.println("Transactions: ");
        for (int i = 0; i < transactions.size(); i++) {
            System.out.println((i + 1) + " -> " + String.format("%.2f", transactions.get(i)));
        }
    }
}
