

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import shoppingapp.authentication.LoginFrame;
import shoppingapp.shoppingcart.ShoppingCart; // Import ShoppingCart class

public class Main {
    public static void main(String[] args) {
        // Create ShoppingCart instance using the singleton pattern
        ShoppingCart shoppingCart = ShoppingCart.getInstance();

        // Create and display the login frame, passing the ShoppingCart instance
        LoginFrame loginFrame = new LoginFrame(shoppingCart);
        loginFrame.setVisible(true);
    }
}
