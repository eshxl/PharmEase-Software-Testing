package pharmease.system;

import static org.junit.Assert.*;
import org.junit.Test;

public class SignUpTest {

    @Test
    public void testEmptyFields() {
        SignUp signUp = new SignUp();

        // Set empty registration details
        signUp.setFullNameText("");
        signUp.setAgeText("");
        signUp.setEmailText("");
        signUp.setPhoneNoText("");
        signUp.setGenderText("");
        signUp.setBloodGroupText("");
        signUp.setUsernameText("");
        signUp.setPasswordText("");

        assertFalse(signUp.registerUser());
    }

    @Test
    public void testInvalidEmail() {
        SignUp signUp = new SignUp();

        // Set registration details with an invalid email
        signUp.setFullNameText("Alice Smith");
        signUp.setAgeText("25");
        signUp.setEmailText("invalid_email");
        signUp.setPhoneNoText("1234567890");
        signUp.setGenderText("Female");
        signUp.setBloodGroupText("AB+");
        signUp.setUsernameText("alice123");
        signUp.setPasswordText("StrongPassword123");

        assertFalse(signUp.registerUser());
    }

    @Test
    public void testInvalidAge() {
        SignUp signUp = new SignUp();

        // Set registration details with invalid age (below 18)
        signUp.setFullNameText("David Miller");
        signUp.setAgeText("16");
        signUp.setEmailText("david@example.com");
        signUp.setPhoneNoText("1234567890");
        signUp.setGenderText("Male");
        signUp.setBloodGroupText("B+");
        signUp.setUsernameText("davidmiller");
        signUp.setPasswordText("StrongPass123");

        assertFalse(signUp.registerUser());
    }

    @Test
    public void testInvalidPhoneNumber() {
        SignUp signUp = new SignUp();

        // Set registration details with an invalid phone number
        signUp.setFullNameText("Emma Watson");
        signUp.setAgeText("28");
        signUp.setEmailText("emma@example.com");
        signUp.setPhoneNoText("12345"); // Invalid phone number format
        signUp.setGenderText("Female");
        signUp.setBloodGroupText("O+");
        signUp.setUsernameText("emmawatson");
        signUp.setPasswordText("StrongPass123");

        assertFalse("Phone number format validation failed", signUp.registerUser());
    }

    @Test
    public void testWeakPasswordWithUserConfirmation() {
        SignUp signUp = new SignUp();

        // Set registration details with a weak password
        signUp.setFullNameText("Robert Johnson");
        signUp.setAgeText("35");
        signUp.setEmailText("robert@example.com");
        signUp.setPhoneNoText("9876543210");
        signUp.setGenderText("Male");
        signUp.setBloodGroupText("A-");
        signUp.setUsernameText("robertjohnson");
        signUp.setPasswordText("weakpass"); // Password doesn't meet strength requirements

        boolean isRegistered = signUp.registerUser();

        if (isRegistered) {
            // Simulate user confirmation or rejection here (true for confirmation, false for rejection)
            boolean userConfirmation = true; // Change this value to simulate user action
            assertTrue("Registration successful and confirmed by the user", userConfirmation);
        } else {
            assertFalse("Registration failed as expected due to weak password", true);
        }
    }

    
    @Test
    public void testValidRegistration() {
        SignUp signUp = new SignUp();

        // Set valid registration details
        signUp.setFullNameText("John Doe");
        signUp.setAgeText("30");
        signUp.setEmailText("john@example.com");
        signUp.setPhoneNoText("1234567890");
        signUp.setGenderText("Male");
        signUp.setBloodGroupText("A+");
        signUp.setUsernameText("johndoe");
        signUp.setPasswordText("StrongPass123");

        assertTrue(signUp.registerUser());
    }
}

