package main;
// David Droege
// SNHU CS 320
// May 25, 2025

// Include HashMap and Map to be used to store user data
import java.util.HashMap;
import java.util.Map;

public class ContactService {
	
	// Define the framework for the Map storage
    private final Map<String, Contact> contacts;

    // Define the function to create new HashMaps
    public ContactService() {
        this.contacts = new HashMap<>();
    }

    // Define the function that creates a contact
    // Add verification steps to ensure no invalid argument or duplicate
    public void addContact(Contact contact) {
        if (contact == null || contact.getContactId() == null) {
            throw new IllegalArgumentException("Contact and contact ID cannot be null");
        }
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID already exists");
        }
        contacts.put(contact.getContactId(), contact);
    }

    // Define a function that allows contacts to be deleted
    // Add a verification step to ensure contactId is not null and exists
    public void deleteContact(String contactId) {
        if (contactId == null) {
            throw new IllegalArgumentException("Contact ID cannot be null");
        }
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        contacts.remove(contactId);
    }

    // Define the function to update a contact
    // ensure that the contact being called is not null and it exists
    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        if (contactId == null) {
            throw new IllegalArgumentException("Contact ID cannot be null");
        }
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        if (firstName != null) {
            contact.setFirstName(firstName);
        }
        if (lastName != null) {
            contact.setLastName(lastName);
        }
        if (phone != null) {
            contact.setPhone(phone);
        }
        if (address != null) {
            contact.setAddress(address);
        }
    }

    // Define a function that calls a specific contactId
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}