package shoppingapp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import shoppingapp.authentication.LoginFrame;
import shoppingapp.shoppingcart.ShoppingCart; // Import ShoppingCart class

public class Main {
    public static void main(String[] args) {
       
        ShoppingCart shoppingCart = ShoppingCart.getInstance();

       
        LoginFrame loginFrame = new LoginFrame(shoppingCart);
        loginFrame.setVisible(true);
    }
}
