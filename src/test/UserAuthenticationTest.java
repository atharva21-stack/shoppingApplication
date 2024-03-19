package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import shoppingapp.authentication.UserAuthentication;

public class UserAuthenticationTest {

    @Test
    public void testUserLogin() {
        UserAuthentication userAuth = new UserAuthentication();
        boolean loggedIn = userAuth.authenticateUser("username1", "password1");

        assertTrue(loggedIn);
    }

    @Test
    public void testInvalidUserLogin() {
        UserAuthentication userAuth = new UserAuthentication();
        boolean loggedIn = userAuth.authenticateUser("invalidusername", "invalidpassword");

        assertFalse(loggedIn);
    }
}
