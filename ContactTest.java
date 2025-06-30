// David Droege
// SNHU CS 320
// May 25, 2025

// import necessary classes and tools to use JUnit testing
package test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.Contact;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
    private Contact contact;

    // Setup the base test case for each contact
    @BeforeEach
    void setUp() {
        contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
    }

    // Setup the Valid Contact Creation
    @Test
    void testValidContactCreation() {
        assertEquals("1234567890", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    // Test that the program catches invalid contactId
    @Test
    void testInvalidContactId() {
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact(null, "John", "Doe", "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St"));
    }

    // Test that the program catches invalid firstName
    @Test
    void testInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("1234567890", null, "Doe", "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("1234567890", "Johnathannnn", "Doe", "1234567890", "123 Main St"));
    }

    // Test that the program catches invalid lastName
    @Test
    void testInvalidLastName() {
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("1234567890", "John", null, "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("1234567890", "John", "Doeistoolong", "1234567890", "123 Main St"));
    }

    // Test that the program catches invalid phone
    @Test
    void testInvalidPhone() {
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("1234567890", "John", "Doe", null, "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("1234567890", "John", "Doe", "123456789", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("1234567890", "John", "Doe", "123456789a", "123 Main St"));
    }

    // Test that the program catches invalid address
    @Test
    void testInvalidAddress() {
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("1234567890", "John", "Doe", "1234567890", null));
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("1234567890", "John", "Doe", "1234567890", 
                "123 Main extra long name street that is way too long to be valid"));
    }

    // Test the program to ensure that it properly updates a contact
    @Test
    void testUpdateFields() {
        contact.setFirstName("Jane");
        contact.setLastName("Smith");
        contact.setPhone("9876543210");
        contact.setAddress("456 Oak Ave");
        
        assertEquals("Jane", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("9876543210", contact.getPhone());
        assertEquals("456 Oak Ave", contact.getAddress());
    }
}