package shoppingapp.authentication;

import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserAuthentication {
    private static final Logger logger = LogManager.getLogger(UserAuthentication.class);
    private Map<String, String> userCredentials;

    public UserAuthentication() {
        // Initialize user credentials (username, password)
        userCredentials = new HashMap<>();
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
        // Add more users as needed
    }

    public boolean authenticateUser(String username, String password) {
        // Check if the provided username exists and the password matches
        boolean isAuthenticated = userCredentials.containsKey(username) && userCredentials.get(username).equals(password);
        if (isAuthenticated) {
            logger.info("User '{}' authenticated successfully.", username); // Log successful authentication
        } else {
            logger.warn("Failed authentication attempt for user '{}'.", username); // Log failed authentication attempt
        }
        return isAuthenticated;
    }
}
