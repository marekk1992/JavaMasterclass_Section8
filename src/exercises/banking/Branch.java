package exercises.banking;

import java.util.ArrayList;

public class Branch {

    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        customers = new ArrayList<Customer>();
    }

    public void addCustomer(String customerName) {
        for (Customer customer : customers) {
            if (customer.getCustomerName().equals(customerName)) {
                System.out.println("ERROR. -> Customer " + customerName + " already exists.");
            }
        }
        Customer customer = new Customer(customerName);
        customers.add(customer);
        System.out.println("Added new customer -> " + customerName);
    }

    public void addTransaction(String customerName, double transaction) {
        Customer customer = getCustomer(customerName);
        if (customer != null) {
            customer.addTransaction(transaction);
        }
    }

    private Customer getCustomer(String name) {
        for (Customer customer : customers) {
            if (customer.getCustomerName().equals(name)) {
                return customer;
            }
        }
        return null;
    }

    public void printCustomerTransactions(String customerName) {
        Customer customer = getCustomer(customerName);
        if (customer != null)  {
            customer.printCustomersTransactions();
        } else {
            System.out.println("ERROR -> Can`t find customer with name " + customerName);
        }
    }

    public void printCustomers(String branchName) {
        System.out.println("Branch " + branchName + " has " + customers.size() + " customers");
        for (int i = 0; i < customers.size(); i++) {
            System.out.println((i + 1) + " -> " + customers.get(i).getCustomerName());
        }
    }

    public String getName() {
        return name;
    }
}
