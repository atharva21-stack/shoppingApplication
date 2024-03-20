package shoppingapp.authentication;

import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserAuthentication {
    private static final Logger logger = LogManager.getLogger(UserAuthentication.class);
    private Map<String, String> userCredentials;

    public UserAuthentication() {
       
        userCredentials = new HashMap<>();
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");

    }

    public boolean authenticateUser(String username, String password) {
        
        boolean isAuthenticated = userCredentials.containsKey(username) && userCredentials.get(username).equals(password);
        if (isAuthenticated) {
            logger.info("User '{}' authenticated successfully.", username); 
        } else {
            logger.warn("Failed authentication attempt for user '{}'.", username); 
        }
        return isAuthenticated;
    }
}
