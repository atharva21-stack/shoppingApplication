import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import authentication.UserAuthentication;

public class Main {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Login");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create the login panel
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(3, 2));

        // Username label and text field
        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField();
        loginPanel.add(userLabel);
        loginPanel.add(userField);

        // Password label and text field
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();
        loginPanel.add(passLabel);
        loginPanel.add(passField);

        // Login button
        JButton loginButton = new JButton("Login");
        loginPanel.add(loginButton);

        // Add the login panel to the frame
        frame.add(loginPanel, BorderLayout.CENTER);

        // Create an instance of UserAuthentication
        UserAuthentication authentication = new UserAuthentication();

        // Action listener for the login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passField.getPassword());

                if (authentication.authenticateUser(username, password)) {
                    JOptionPane.showMessageDialog(frame, "Login Successful!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Login Failed. Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Set the frame visible
        frame.setVisible(true);
    }
}
