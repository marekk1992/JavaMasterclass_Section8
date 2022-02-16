package exercises.mobilePhone;

import java.util.ArrayList;

public class MobilePhone {

    private ArrayList<Contact> contactsList = new ArrayList<Contact>();

    public void printContactsList() {
        System.out.println("You have " + contactsList.size() + " contacts in your mobile phonebook");
        for (int i = 0; i < contactsList.size(); i++) {
            System.out.println((i+1) + ". " + contactsList.get(i).getName() + " ("
                    + contactsList.get(i).getPhoneNumber() + ")");
        }
    }

    public void addNewContact(Contact contact) {
        contactsList.add(contact);
    }

    private int findContact(String name) {
        for (int i = 0; i < contactsList.size(); i++) {
            if (contactsList.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public boolean inPhonebook(String name) {
        int position = findContact(name);
        if (position >= 0) {
            return true;
        }
        return false;
    }

    public void removeContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            contactsList.remove(position);
            System.out.println("Contact " + name + " removed from phonebook.");
        }
    }

    public void updateContact(String currentContactName, Contact newContact) {
        int position = findContact(currentContactName);
        if (position >= 0) {
            contactsList.set(position, newContact);
        }
    }
}
