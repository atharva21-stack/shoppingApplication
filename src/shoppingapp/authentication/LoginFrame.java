package shoppingapp.authentication;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import shoppingapp.HomeScreen;
import shoppingapp.shoppingcart.ShoppingCart; // Import ShoppingCart class

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private static final Logger logger = LogManager.getLogger(LoginFrame.class);

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    private UserAuthentication authentication;
    private ShoppingCart shoppingCart; 

    
    public LoginFrame(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart; 

        // Set up the frame
        setTitle("Login");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 

        
        JPanel panel = new JPanel(new GridLayout(3, 2));
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");

        
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel()); 
        panel.add(loginButton);

        
        add(panel);

        
        authentication = new UserAuthentication();

        
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (authentication.authenticateUser(username, password)) {
                    dispose();
                    openHomeScreen(username); 
                    logger.info("User '{}' logged in successfully.", username); 
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Login failed. Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
                    logger.warn("Failed login attempt for user '{}'.", username); 
                }
            }
        });
    }

    private void openHomeScreen(String username) {
        HomeScreen homeScreen = new HomeScreen(username, shoppingCart); 
        homeScreen.setVisible(true);
    }
}
