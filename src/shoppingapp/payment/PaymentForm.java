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
    private String username;

    public PaymentForm(double totalAmount, List<Order> orders, String username) {
        this.totalAmount = totalAmount;
        this.orders = orders; 
        this.username = username;
        
    }

    public PaymentForm(double totalAmount, List<Order> orders) {
        this.totalAmount = totalAmount;
        this.orders = orders; 
        this.paymentGateway = new MockPaymentGateway(); 

        setTitle("Payment Form");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);


        
        JPanel mainPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

       
        JLabel cardNumberLabel = new JLabel("Card Number:");
        JTextField cardNumberField = new JTextField();
        mainPanel.add(cardNumberLabel);
        mainPanel.add(cardNumberField);

       
        JLabel expiryDateLabel = new JLabel("Expiry Date:");
        JTextField expiryDateField = new JTextField();
        mainPanel.add(expiryDateLabel);
        mainPanel.add(expiryDateField);

        
        JLabel cvvLabel = new JLabel("CVV:");
        JTextField cvvField = new JTextField();
        mainPanel.add(cvvLabel);
        mainPanel.add(cvvField);

        
        JButton payButton = new JButton("Pay $" + totalAmount);
        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cardNumber = cardNumberField.getText();
                String expiryDate = expiryDateField.getText();
                String cvv = cvvField.getText();

                logger.info("Attempting to process payment...");
                
                boolean paymentSuccess = paymentGateway.processPayment(cardNumber, expiryDate, cvv, totalAmount);

                if (paymentSuccess) {
                    logger.info("Payment successful. Order placed.");
                    JOptionPane.showMessageDialog(PaymentForm.this, "Order placed successfully!", "Order Placed", JOptionPane.INFORMATION_MESSAGE);
                    dispose(); 

                    
                    openManageOrdersPage();
                } else {
                    logger.error("Payment failed.");
                    JOptionPane.showMessageDialog(PaymentForm.this, "Payment failed. Please check your card details and try again.", "Payment Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        mainPanel.add(payButton);

        
        add(mainPanel);

        setVisible(true);
    }
    private void openManageOrdersPage() {
        
        if (orders != null) {
            
            ManageOrders manageOrders = new ManageOrders(orders, username);
            manageOrders.setVisible(true);
        } else {
            
            System.out.println("Orders list is null. Cannot open ManageOrders page.");
        }
    }
}