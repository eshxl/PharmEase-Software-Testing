package pharmease.system;

import static org.junit.Assert.*;
import org.junit.Test;

public class LoginTest {

    @Test
    public void testGetUsernameAndPassword() {
        Login login = new Login();

        // Set username and password
        String username = "eshxl";
        String password = "shell";
        login.setUsernameText(username);
        login.setPasswordText(password);

        // Get username and password
        String retrievedUsername = login.getUsernameText();
        String retrievedPassword = login.getPasswordText();

        // Assert against expected values
        assertEquals(username, retrievedUsername);
        assertEquals(password, retrievedPassword);
    }
    
    @Test
    public void testEmptyUsername() {
        Login login = new Login();

        // Set empty username and valid password
        String emptyUsername = "";
        String validPassword = "password123";
        login.setUsernameText(emptyUsername);
        login.setPasswordText(validPassword);

        assertFalse(login.validateLogin());
    }

    @Test
    public void testEmptyPassword() {
        Login login = new Login();

        // Set valid username and empty password
        String validUsername = "user123";
        String emptyPassword = "";
        login.setUsernameText(validUsername);
        login.setPasswordText(emptyPassword);

        assertFalse(login.validateLogin());
    }

    @Test
    public void testInvalidUsername() {
        Login login = new Login();

        // Set invalid username and valid password
        String invalidUsername = "invalid_user";
        String validPassword = "password123";
        login.setUsernameText(invalidUsername);
        login.setPasswordText(validPassword);

        assertFalse(login.validateLogin());
    }

    @Test
    public void testInvalidPassword() {
        Login login = new Login();

        // Set valid username and invalid password
        String validUsername = "eshxl";
        String invalidPassword = "pass";
        login.setUsernameText(validUsername);
        login.setPasswordText(invalidPassword);

        assertFalse(login.validateLogin());
    }

    @Test
    public void testValidCredentials() {
        Login login = new Login();

        // Set valid username and password
        String validUsername = "eshxl";
        String validPassword = "shell";
        login.setUsernameText(validUsername);
        login.setPasswordText(validPassword);

        assertTrue(login.validateLogin());
    }
}
