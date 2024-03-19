package shoppingapp.payment;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MockPaymentGateway {

    public boolean authorizePayment(double amount) {
        // Simulate authorizing the payment
        // Return true if payment is authorized, false otherwise
        return Math.random() < 0.9; // Simulate 90% success rate
    }

    public boolean capturePayment(double amount) {
        // Simulate capturing the payment
        // Return true if payment is captured successfully, false otherwise
        return Math.random() < 0.95; // Simulate 95% success rate
    }

    public boolean processPayment(String cardNumber, String expiryDate, String cvv, double amount) {
        // Simulate processing the payment
        boolean paymentSuccess = true; // Simulate 95% success rate

        if (paymentSuccess) {
            // Show loading dialog
            JDialog loadingDialog = new JDialog();
            loadingDialog.setTitle("Processing Payment");
            loadingDialog.setModal(true);
            JLabel messageLabel = new JLabel("Contacting bank, please wait...");


            // Simulate delay using javax.swing.Timer
            Timer timer = new Timer(3000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Close loading dialog and show payment success message
                    loadingDialog.dispose();
                    JOptionPane.showMessageDialog(null, "Payment processed successfully!", "Payment Success", JOptionPane.INFORMATION_MESSAGE);
                }
            });
            timer.setRepeats(false); // Only execute once
            timer.start();
        }

        return paymentSuccess;
    }

}
