package shoppingapp.payment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import shoppingapp.orders.*;
import java.util.List;

import shoppingapp.orders.ManageOrders;
import shoppingapp.orders.Order;

public class PaymentForm extends JFrame {
    private static final Logger logger = LogManager.getLogger(PaymentForm.class);
    private List<Order> orders;
    private double totalAmount;
    private MockPaymentGateway paymentGateway;
    private String username; // New field to store the authenticated username

    public PaymentForm(double totalAmount, List<Order> orders, String username) {
        this.totalAmount = totalAmount;
        this.orders = orders; // Initialize the orders variable
        this.username = username;
        
    }

    public PaymentForm(double totalAmount, List<Order> orders) {
        this.totalAmount = totalAmount;
        this.orders = orders; // Initialize the orders variable
        this.paymentGateway = new MockPaymentGateway(); 

        setTitle("Payment Form");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);


        // Create main panel with grid layout
        JPanel mainPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Add card number label and text field
        JLabel cardNumberLabel = new JLabel("Card Number:");
        JTextField cardNumberField = new JTextField();
        mainPanel.add(cardNumberLabel);
        mainPanel.add(cardNumberField);

        // Add expiry date label and text field
        JLabel expiryDateLabel = new JLabel("Expiry Date:");
        JTextField expiryDateField = new JTextField();
        mainPanel.add(expiryDateLabel);
        mainPanel.add(expiryDateField);

        // Add CVV label and text field
        JLabel cvvLabel = new JLabel("CVV:");
        JTextField cvvField = new JTextField();
        mainPanel.add(cvvLabel);
        mainPanel.add(cvvField);

        // Add button to process payment
        JButton payButton = new JButton("Pay $" + totalAmount);
        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cardNumber = cardNumberField.getText();
                String expiryDate = expiryDateField.getText();
                String cvv = cvvField.getText();

                logger.info("Attempting to process payment...");
                // Simulate processing payment
                boolean paymentSuccess = paymentGateway.processPayment(cardNumber, expiryDate, cvv, totalAmount);

                if (paymentSuccess) {
                    logger.info("Payment successful. Order placed.");
                    JOptionPane.showMessageDialog(PaymentForm.this, "Order placed successfully!", "Order Placed", JOptionPane.INFORMATION_MESSAGE);
                    dispose(); // Close the payment form

                    // Open the manage orders page
                    openManageOrdersPage();
                } else {
                    logger.error("Payment failed.");
                    JOptionPane.showMessageDialog(PaymentForm.this, "Payment failed. Please check your card details and try again.", "Payment Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        mainPanel.add(payButton);

        // Add main panel to frame
        add(mainPanel);

        setVisible(true);
    }
    private void openManageOrdersPage() {
        // Ensure that orders is not null before opening ManageOrders page
        if (orders != null) {
            // Open the manage orders page with the list of orders and the authenticated username
            ManageOrders manageOrders = new ManageOrders(orders, username);
            manageOrders.setVisible(true);
        } else {
            // Handle the case where orders is null
            System.out.println("Orders list is null. Cannot open ManageOrders page.");
        }
    }
}