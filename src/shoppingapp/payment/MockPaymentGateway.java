package shoppingapp.payment;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MockPaymentGateway {

    public boolean authorizePayment(double amount) {
        
        return Math.random() < 0.9; 
    }

    public boolean capturePayment(double amount) {
        
        return Math.random() < 0.95;
    }

    public boolean processPayment(String cardNumber, String expiryDate, String cvv, double amount) {
       
        boolean paymentSuccess = true; 

        if (paymentSuccess) {
            // Show loading dialog
            JDialog loadingDialog = new JDialog();
            loadingDialog.setTitle("Processing Payment");
            loadingDialog.setModal(true);
            JLabel messageLabel = new JLabel("Contacting bank, please wait...");


           
            Timer timer = new Timer(3000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    loadingDialog.dispose();
                    JOptionPane.showMessageDialog(null, "Payment processed successfully!", "Payment Success", JOptionPane.INFORMATION_MESSAGE);
                }
            });
            timer.setRepeats(false); 
            timer.start();
        }

        return paymentSuccess;
    }

}
