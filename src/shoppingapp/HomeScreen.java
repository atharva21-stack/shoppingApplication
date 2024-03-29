package shoppingapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import shoppingapp.catalog.ProductCatalog;
import shoppingapp.shoppingcart.ShoppingCart;

public class HomeScreen extends JFrame {
    private static final Logger logger = LogManager.getLogger(HomeScreen.class);

    private final ShoppingCart shoppingCart; 
    private final String username; 
    public HomeScreen(String username, ShoppingCart shoppingCart) {
        this.username = username;
        this.shoppingCart = shoppingCart;

        setTitle("Shopping App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

       
        JPanel panel = new JPanel(new GridLayout(3, 1));
        JLabel titleLabel = new JLabel("Welcome to Shopping App", JLabel.CENTER);
        JButton browseButton = new JButton("Browse Items");
        JButton quitButton = new JButton("Quit");

        
        panel.add(titleLabel);
        panel.add(browseButton);
        panel.add(quitButton);

        
        add(panel);

        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openProductCatalog();
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void openProductCatalog() {
        ProductCatalog productCatalog = new ProductCatalog(username); 
        productCatalog.setVisible(true);
        logger.info("Opened product catalog.");
    }
}
