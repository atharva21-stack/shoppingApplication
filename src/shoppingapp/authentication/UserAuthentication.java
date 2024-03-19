package authentication;

import java.util.HashMap;
import java.util.Map;

public class UserAuthentication {
    private Map<String, String> userCredentials;

    public UserAuthentication() {
        // Initialize user credentials (username, password)
        userCredentials = new HashMap<>();
        userCredentials.put("user1", "12345");
        userCredentials.put("user2", "12345");
        // Add more users as needed
    }

    public boolean authenticateUser(String username, String password) {
        // Check if the provided username exists and the password matches
        return userCredentials.containsKey(username) && userCredentials.get(username).equals(password);
    }
}
