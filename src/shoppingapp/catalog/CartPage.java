package shoppingapp.catalog;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import shoppingapp.payment.PaymentForm;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CartPage extends JFrame {
    private List<Product> cartItems;

    public CartPage(List<Product> cartItems, String username) {
        this.cartItems = cartItems;

        setTitle("Cart Page");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Create main panel with grid layout
        JPanel mainPanel = new JPanel(new GridLayout(cartItems.size() + 2, 1));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Add items to cart
        for (Product item : cartItems) {
            JLabel itemLabel = new JLabel(item.getName() + " - $" + item.getPrice());
            mainPanel.add(itemLabel);
        }

        // Add total price label
        double totalPrice = calculateTotalPrice();
        JLabel totalPriceLabel = new JLabel("Total Price: $" + totalPrice);
        mainPanel.add(totalPriceLabel);

        // Add "Finish and Pay" button
        JButton finishAndPayButton = new JButton("Finish and Pay");
        finishAndPayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open payment form
                openPaymentForm(totalPrice); // Pass the total price
            }
        });
        mainPanel.add(finishAndPayButton);

        // Add main panel to frame
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane);

        setVisible(true);
    }

    private double calculateTotalPrice() {
        double totalPrice = 0;
        for (Product item : cartItems) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }
    
    

    // Open payment form method
    private void openPaymentForm(double totalAmount) {
        PaymentForm paymentForm = new PaymentForm(totalAmount, null);
        paymentForm.setVisible(true);
    }
}
