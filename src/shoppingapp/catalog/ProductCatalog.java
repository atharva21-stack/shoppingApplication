package shoppingapp.catalog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import shoppingapp.HomeScreen;
import shoppingapp.orders.ManageOrders;
import factory.ProductFactory;

public class ProductCatalog extends JFrame {
    private static final Logger logger = LogManager.getLogger(ProductCatalog.class);
    
    private static final String[] PRODUCT_NAMES = {"Bread", "Milk", "Eggs", "Chicken", "Coriander", "Onions", "Tomatoes", "Chillies", "Butter", "Water Bottles"};
    private static final double[] PRODUCT_PRICES = {2.99, 1.99, 3.49, 5.99, 0.99, 1.49, 1.29, 0.79, 3.49, 4.99};
    private static final String[] PRODUCT_BRANDS = {"Groceries", "Groceries", "Groceries", "Groceries", "Groceries", "Groceries", "Groceries", "Groceries", "Groceries", "Groceries"};
    private static final String[] PRODUCT_IMAGE_PATHS = {"/shoppingapp/Images/bread.png", "/shoppingapp/Images/milk.png", "/shoppingapp/Images/eggs.png", "/shoppingapp/Images/chicken.png", "/shoppingapp/Images/coriander.png", "/shoppingapp/Images/onions.png", "/shoppingapp/Images/tomatoes.png", "/shoppingapp/Images/chillies.png", "/shoppingapp/Images/butter.png", "/shoppingapp/Images/water.png"};

    private List<Product> cartItems;
    private String username;

    public ProductCatalog(String username) {
        this.username = username;
        cartItems = new ArrayList<>();
        initializeUI();
    }

    private void initializeUI() {
        logger.info("Initializing Product Catalog UI.");
        setTitle("Product Catalog");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        List<Product> productList = createProductListSortedByPrice();

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JPanel topPanel = new JPanel(new BorderLayout());
        JButton backButton = new JButton("<-");
        backButton.setIcon(new ImageIcon("back_arrow_icon.png")); 
        backButton.addActionListener(e -> navigateBack());
        topPanel.add(backButton, BorderLayout.WEST);
        mainPanel.add(topPanel, BorderLayout.NORTH);

       
        JPanel productPanel = new JPanel(new GridLayout(0, 3, 20, 20)); 
        addProductsToPanel(productPanel, productList);
        JScrollPane scrollPane = new JScrollPane(productPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

       
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.addActionListener(e -> openCheckoutPage());
        
        buttonPanel.add(checkoutButton);
       
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    private List<Product> createProductListSortedByPrice() {
        logger.debug("Creating sorted list of products by price.");
    
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < PRODUCT_NAMES.length; i++) {
            
            Product product = ProductFactory.createProduct("grocery", PRODUCT_NAMES[i], PRODUCT_PRICES[i], PRODUCT_BRANDS[i], PRODUCT_IMAGE_PATHS[i]);
            productList.add(product);
        }

        return productList;
    }


    private void addProductsToPanel(JPanel panel, List<Product> productList) {
        for (Product product : productList) {
            JPanel productPanel = new JPanel(new BorderLayout());

            
            URL imageURL = getClass().getResource(product.getImagePath());
            if (imageURL != null) {
                ImageIcon imageIcon = new ImageIcon(imageURL);
                JLabel imageLabel = new JLabel(imageIcon);
                productPanel.add(imageLabel, BorderLayout.CENTER);
            } else {
                System.err.println("Image not found: " + product.getImagePath());
            }

           
            JLabel nameLabel = new JLabel(product.getName());
            JLabel priceLabel = new JLabel("$" + String.format("%.2f", product.getPrice()));

           
            JPanel quantityPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel quantityLabel = new JLabel("Quantity:");
            JTextField quantityField = new JTextField(3); 
            quantityField.setText("1"); 
            JButton addButton = new JButton("+");
            addButton.addActionListener(e -> {
                int quantity = Integer.parseInt(quantityField.getText());
                quantityField.setText(String.valueOf(quantity + 1));
            });
            JButton minusButton = new JButton("-");
            minusButton.addActionListener(e -> {
                int quantity = Integer.parseInt(quantityField.getText());
                if (quantity > 1) { // Ensure quantity is not negative
                    quantityField.setText(String.valueOf(quantity - 1));
                }
            });
            quantityPanel.add(quantityLabel);
            quantityPanel.add(minusButton);
            quantityPanel.add(quantityField);
            quantityPanel.add(addButton);

            // Add to cart button
            JButton addToCartButton = new JButton("Add to Cart");
            addToCartButton.addActionListener(e -> {
                int quantity = Integer.parseInt(quantityField.getText());
                for (int i = 0; i < quantity; i++) {
                    cartItems.add(product);
                }
                JOptionPane.showMessageDialog(this, quantity + " " + product.getName() + "(s) added to cart.");
                logger.info("{} {}(s) added to cart.", quantity, product.getName());
            });

            // Add components to product panel
            productPanel.add(nameLabel, BorderLayout.NORTH);
            productPanel.add(priceLabel, BorderLayout.CENTER);
            productPanel.add(quantityPanel, BorderLayout.WEST);
            productPanel.add(addToCartButton, BorderLayout.SOUTH);

            panel.add(productPanel);
        }
    }

    private void openCheckoutPage() {
        logger.info("Opening checkout page.");
        CartPage cartPage = new CartPage(cartItems, username);
        cartPage.setVisible(true);
    }

    private void openManageOrdersPage() {
        logger.info("Opening manage orders page.");
        ManageOrders manageOrders = new ManageOrders(cartItems);
        manageOrders.setVisible(true);
    }

    private void navigateBack() {
        logger.info("Navigating back to home screen.");
        dispose(); // Close the current window
        HomeScreen homeScreen = new HomeScreen(username, null);
        homeScreen.setVisible(true);
    }
}
