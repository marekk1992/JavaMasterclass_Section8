package exercises.banking;

import java.util.ArrayList;

public class Customer {

    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name) {
        this.name = name;
        transactions = new ArrayList<Double>();
        transactions.add(Double.valueOf(1000));
    }

    public String getCustomerName() {
        return name;
    }

    public void addTransaction(double transaction) {
        transactions.add(Double.valueOf(transaction));
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }
}
