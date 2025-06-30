package main;
// David Droege
// SNHU CS 320
// May 25, 2025

public class Contact {
	
	// Define the strings that will store user data
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Define Contact, which will store all the above defined data strings
    // Each user input will be stored separately
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        // Verify inputs for contactId
    	if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Contact ID must not be null and must not exceed 10 characters");
        }
    	// Verify inputs for firstName
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name must not be null and must not exceed 10 characters");
        }
        // Verify inputs for lastName
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name must not be null and must not exceed 10 characters");
        }
        // Verify inputs for phone
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone number must be exactly 10 digits");
        }
        // Verify inputs for address
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address must not be null and must not exceed 30 characters");
        }

        // Set the users input to be stored in Contact
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Define functions that can be used to call user information from Contact by indexing the proper data name
    
    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    // Define functions that allow the user to update their first name, last name, phone, and address
    // Include verifying statements that prevent illegal arguments
    
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name must not be null and must not exceed 10 characters");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name must not be null and must not exceed 10 characters");
        }
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone number must be exactly 10 digits");
        }
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address must not be null and must not exceed 30 characters");
        }
        this.address = address;
    }
}