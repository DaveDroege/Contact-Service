// David Droege
// SNHU CS 320
// May 25, 2025

package test;

// import all necessary classes and tools for JUnit testing
import main.ContactService;
import main.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
    private ContactService contactService;
    private Contact contact;

    // Setup the test case
    @BeforeEach
    void setUp() {
        contactService = new ContactService();
        contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
    }

    // Setup the test for addin a contact
    @Test
    void testAddContact() {
        contactService.addContact(contact);
        assertEquals(contact, contactService.getContact("1234567890"));
    }

    // Test the the system notices a duplicate
    @Test
    void testAddDuplicateContact() {
        contactService.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> 
            contactService.addContact(new Contact("1234567890", "Jane", "Smith", "9876543210", "456 Oak Ave")));
    }

    // Test that contacts can be deleted
    @Test
    void testDeleteContact() {
        contactService.addContact(contact);
        contactService.deleteContact("1234567890");
        assertNull(contactService.getContact("1234567890"));
    }

    // Test that the system catches a non existent contact being called
    @Test
    void testDeleteNonexistentContact() {
        assertThrows(IllegalArgumentException.class, () -> 
            contactService.deleteContact("1234567890"));
    }

    // Test that the system can update contacts
    @Test
    void testUpdateContact() {
        contactService.addContact(contact);
        contactService.updateContact("1234567890", "Jane", "Smith", "9876543210", "456 Oak Ave");
        Contact updatedContact = contactService.getContact("1234567890");
        
        assertEquals("Jane", updatedContact.getFirstName());
        assertEquals("Smith", updatedContact.getLastName());
        assertEquals("9876543210", updatedContact.getPhone());
        assertEquals("456 Oak Ave", updatedContact.getAddress());
    }

    // Test that the system catches a non existent contact being called to be updated
    @Test
    void testUpdateNonexistentContact() {
        assertThrows(IllegalArgumentException.class, () -> 
            contactService.updateContact("1234567890", "Jane", "Smith", "9876543210", "456 Oak Ave"));
    }

    // Test that the system catches an incomplete update
    @Test
    void testPartialUpdate() {
        contactService.addContact(contact);
        contactService.updateContact("1234567890", "Jane", null, null, null);
        Contact updatedContact = contactService.getContact("1234567890");
        
        assertEquals("Jane", updatedContact.getFirstName());
        assertEquals("Doe", updatedContact.getLastName());
        assertEquals("1234567890", updatedContact.getPhone());
        assertEquals("123 Main St", updatedContact.getAddress());
    }
}