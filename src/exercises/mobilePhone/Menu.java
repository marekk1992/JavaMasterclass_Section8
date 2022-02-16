package exercises.mobilePhone;

import java.util.Scanner;

public class Menu {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();
    private static boolean quit = false;
    private static int choice;

    public static void initiate() {
        printInstructions();
        while (!quit) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    mobilePhone.printContactsList();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    searchForContact();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }
    }

    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the phonebook");
        System.out.println("\t 2 - To add a contact to phonebook");
        System.out.println("\t 3 - To update a contact in phonebook");
        System.out.println("\t 4 - To remove a contact from phonebook");
        System.out.println("\t 5 - To search for a contact in the list");
        System.out.println("\t 6 - To quit the application.");
    }

    public static void addContact() {
        System.out.print("Enter a name: ");
        String name = scanner.nextLine();
        System.out.print("Enter a phone number: ");
        String phoneNumber = scanner.nextLine();
        Contact contact = new Contact(name, phoneNumber);
        mobilePhone.addNewContact(contact);
    }

    public static void searchForContact() {
        System.out.print("Enter a name: ");
        String searchName = scanner.nextLine();
        System.out.println(mobilePhone.getContact(searchName));
    }

    public static void removeContact() {
        System.out.print("Enter a name: ");
        String nameToRemove = scanner.nextLine();
        mobilePhone.removeContact(nameToRemove);
    }

    public static void updateContact() {
        System.out.print("Enter a contact name you want to update: ");
        String currentContactName = scanner.nextLine();

        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new phone number: ");
        String phoneNumber = scanner.nextLine();

        Contact contact = new Contact(name, phoneNumber);
        mobilePhone.updateContact(currentContactName, contact);
    }
}
