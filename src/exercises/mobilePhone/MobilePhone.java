package exercises.mobilePhone;

import java.util.ArrayList;

public class MobilePhone {

    private ArrayList<Contact> contacts = new ArrayList<Contact>();

    public void printContactsList() {
        System.out.println("You have " + contacts.size() + " contacts in your mobile phonebook");
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i + 1) + ". " + contacts.get(i).getName() + " ("
                    + contacts.get(i).getPhoneNumber() + ")");
        }
    }

    public void addNewContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Contact " + contact.getName() + ", " + contact.getPhoneNumber()
                + " added to phonebook");
    }

    public Contact getContact(String name) {
        int position = indexOfContact(name);
        if (inPhonebook(position)) {
            Contact contact = new Contact(contacts.get(position).getName(),
                    contacts.get(position).getPhoneNumber());
            System.out.println("Found: " + contact.getName() + ", phone No. "
                    + contact.getPhoneNumber());
            return contact;
        }
        System.out.println("There is no contact with name " + name + " in phonebook");
        return null;
    }

    private int indexOfContact(String name) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    private boolean inPhonebook(int index) {
        return index >= 0;
    }

    public void removeContact(String name) {
        int position = indexOfContact(name);
        if (inPhonebook(position)) {
            contacts.remove(position);
            System.out.println("Contact " + name + " removed from phonebook.");
        } else {
            System.out.println("There is no contact with name " + name + " in phonebook.");
        }
    }

    public void updateContact(String currentContactName, Contact newContact) {
        int position = indexOfContact(currentContactName);
        if (inPhonebook(position)) {
            contacts.set(position, newContact);
            System.out.println("Contact " + currentContactName + " updated with " +
                    newContact.getName() + ", " + newContact.getPhoneNumber());
            return;
        }
        System.out.println("There is no contact with name " + currentContactName + " in phonebook.");
    }
}
