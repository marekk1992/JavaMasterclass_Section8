package exercises.banking;

import java.util.ArrayList;

public class Branch {

    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        customers = new ArrayList<Customer>();
    }

    public Customer addCustomer(String name) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getCustomerName().equals(name)) {
                System.out.println("ERROR. -> Customer " + name + " already exists.");
                return null;
            }
        }
        Customer customer = new Customer(name);
        return customer;
    }

    public boolean addTransaction(String name, double transaction) {
        int position = indexOfCustomer(name);
        if (position >= 0) {
            customers.get(position).addTransaction(transaction);
            return true;
        };
        return false;
    }

    private int indexOfCustomer(String name) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getCustomerName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void printTransactions(String customerName) {
        int position = indexOfCustomer(customerName);
        if (position >= 0) {
            System.out.println("Transactions: ");
            for (int i = 0; i < (customers.get(position)).getTransactions().size(); i++) {
                System.out.println((i + 1) + " -> " + customers.get(position).getTransactions().get(i));
            }
        } else {
            System.out.println("ERROR -> Can`t find customer with name " + customerName);
        }
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public String getName() {
        return name;
    }
}
