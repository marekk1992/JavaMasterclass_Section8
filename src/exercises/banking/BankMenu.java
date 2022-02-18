package exercises.banking;

import java.util.Scanner;

public class BankMenu {

    private Scanner scanner = new Scanner(System.in);
    private Bank bank = new Bank();

    public void operateBank() {
        boolean quit = false;
        printMenu();
        while (!quit) {
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printMenu();
                    break;
                case 1:
                    printCustomersList();
                    break;
                case 2:
                    printTransactionsList();
                    break;
                case 3:
                    addNewTransaction();
                    break;
                case 4:
                    addNewBranch();
                    break;
                case 5:
                    addNewCustomer();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }
    }

    public void printMenu() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print list of customers for a particular branch.");
        System.out.println("\t 2 - To print list of customers transactions.");
        System.out.println("\t 3 - To add new transaction.");
        System.out.println("\t 4 - To add new branch");
        System.out.println("\t 5 - To add customer to the particular branch.");
        System.out.println("\t 6 - To quit the application.");
    }

    public void printCustomersList() {
        System.out.print("Enter a branch name: ");
        String name = scanner.nextLine();
        bank.printCustomersList(name);
    }

    public void printTransactionsList() {
        System.out.print("Enter a branch name: ");
        String branchName = scanner.nextLine();
        System.out.print("Enter a customer name: ");
        String customerName = scanner.nextLine();
        bank.printTransactions(branchName, customerName);
    }

    public void addNewTransaction() {
        System.out.print("Enter a branch name: ");
        String branchName = scanner.nextLine();
        System.out.print("Enter a customer name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter transaction: ");
        double transaction = scanner.nextDouble();
        bank.addTransaction(branchName, customerName, transaction);
    }

    public void addNewBranch() {
        System.out.print("Enter a branch name: ");
        Branch branch = new Branch(scanner.nextLine());
        bank.addBranch(branch);
    }

    public void addNewCustomer() {
        System.out.print("Enter branch name where to add new customer: ");
        String branchName = scanner.nextLine();
        System.out.print("Enter new customer name: ");
        String customerName = scanner.nextLine();
        bank.addCustomer(branchName, customerName);
    }
}
