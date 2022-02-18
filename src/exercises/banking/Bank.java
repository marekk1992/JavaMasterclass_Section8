package exercises.banking;

import java.util.ArrayList;

public class Bank {

    private ArrayList<Branch> branch = new ArrayList<Branch>();

    public void addBranch(Branch newBranch) {
        branch.add(newBranch);
    }

    public boolean addCustomer(String branchName, String newCustomer) {
        int position = indexOfBranch(branchName);
        if (position >= 0) {
            Customer customer = branch.get(position).addCustomer(newCustomer);
            branch.get(position).getCustomers().add(customer);
            System.out.println("Added customer -> " + newCustomer + " to branch -> " + branchName);
            return true;
        }
        System.out.println("ERROR -> Addition failed. Please check your input.");
        return false;
    }

    public boolean addTransaction(String branchName, String customerName, double transaction) {
        int branchPosition = indexOfBranch(branchName);
        int customerPosition = indexOfCustomer(branchName, customerName);
        if (branchPosition >= 0 && customerPosition >= 0) {
            branch.get(branchPosition).addTransaction(customerName, transaction);
            System.out.println("Added new transaction " + branchName + "->" + customerName +
                    "->" + transaction);
            return true;
        }
        System.out.println("ERROR -> Addition failed. Please check whether branch/customer exists.");
        return false;
    }

    private int indexOfBranch(String name) {
        for (int i = 0; i < branch.size(); i++) {
            if (branch.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    private int indexOfCustomer(String branchName, String customerName) {
        int branchPosition = indexOfBranch(branchName);
        for (int i = 0; i < branch.get(branchPosition).getCustomers().size(); i++) {
            if (branch.get(branchPosition).getCustomers().get(i).getCustomerName().equals(customerName)) {
                return i;
            }
        }
        return -1;
    }

    public void printCustomersList(String branchName) {
        int position = indexOfBranch(branchName);
        if (position >= 0) {
            int numberOfCustomers = branch.get(position).getCustomers().size();
            System.out.println("Branch " + branchName + " has "
                    + numberOfCustomers + " customers");
            for (int i = 0; i < numberOfCustomers; i++) {
                System.out.println((i + 1) + ". " + branch.get(position).getCustomers().get(i).getCustomerName());
            }
        } else {
            System.out.println("ERROR -> Can`t find branch.");
        }
    }

    public void printTransactions(String branchName, String customerName) {
        int branchPosition = indexOfBranch(branchName);
        if (branchPosition >= 0) {
            branch.get(branchPosition).printTransactions(customerName);
        } else {
            System.out.println("ERROR -> Can`t find branch with name " + branchName);
        }
    }
}
