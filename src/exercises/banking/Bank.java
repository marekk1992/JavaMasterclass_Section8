package exercises.banking;

import java.util.ArrayList;

public class Bank {

    private ArrayList<Branch> branches = new ArrayList<Branch>();

    public void addBranch(Branch newBranch) {
        branches.add(newBranch);
        System.out.println("Added new branch -> " + newBranch.getName());
    }

    public void addCustomer(String branchName, String newCustomerName) {
        Branch branch = getBranch(branchName);
        if (branch != null) {
            if (!branch.addCustomer(newCustomerName)) {
                System.out.println("ERROR -> Addition failed. Customer " + newCustomerName
                        + " already exists.");
            }
        } else {
            System.out.println("ERROR -> Can`t find branch with name " + branchName);
        }
    }

    public void addTransaction(String branchName, String customerName, double transaction) {
        Branch branch = getBranch(branchName);
        if (branch != null) {
            branch.addTransaction(customerName, transaction);
            System.out.println("Added new transaction " + branchName + "->" + customerName +
                    "->" + transaction);
        } else {
            System.out.println("ERROR -> Addition failed. Please check whether branch/customer exists.");
        }
    }

    private Branch getBranch(String name) {
        for (Branch branch : branches) {
            if (branch.getName().equals(name)) {
                return branch;
            }
        }
        return null;
    }

    public void printBranchCustomers(String branchName) {
        Branch branch = getBranch(branchName);
        if (branch != null) {
            branch.printCustomers(branchName);
        } else {
            System.out.println("ERROR -> Can`t find branch.");
        }
    }

    public void printTransactions(String branchName, String customerName) {
        Branch branch = getBranch(branchName);
        if (branch != null) {
            branch.printCustomerTransactions(customerName);
        } else {
            System.out.println("ERROR -> Can`t find branch with name " + branchName);
        }
    }
}
