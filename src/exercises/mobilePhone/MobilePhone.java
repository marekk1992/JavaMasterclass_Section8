package exercises.mobilePhone;

import java.util.ArrayList;

public class MobilePhone {

    private ArrayList<Contact> contacts = new ArrayList<Contact>();

    public void printContactsList() {
        System.out.println("You have " + contacts.size() + " contacts in your mobile phonebook");
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i+1) + ". " + contacts.get(i).getName() + " ("
                    + contacts.get(i).getPhoneNumber() + ")");
        }
    }

    public void addNewContact(Contact contact) {
        contacts.add(contact);
    }

    private int indexOfContact(String name) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public boolean inPhonebook(String name) {
        int position = indexOfContact(name);
        return position >= 0;
        }


    public void removeContact(String name) {
        int position = indexOfContact(name);
        if (position >= 0) {
            contacts.remove(position);
            System.out.println("Contact " + name + " removed from phonebook.");
        }
    }

    public void updateContact(String currentContactName, Contact newContact) {
        int position = indexOfContact(currentContactName);
        if (position >= 0) {
            contacts.set(position, newContact);
        }
    }
}
