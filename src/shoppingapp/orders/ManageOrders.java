package shoppingapp.orders;

import javax.swing.*;

import shoppingapp.catalog.Product;

import java.awt.*;
import java.util.List;

public class ManageOrders extends JFrame {
    private List<Order> orders;

    public ManageOrders(List<Order> orders, String username) {
        this.orders = orders;

        setTitle("Manage Orders");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        
        JPanel mainPanel = new JPanel(new GridLayout(orders.size() + 1, 1)); 

        
        JPanel headerPanel = new JPanel(new GridLayout(1, 5));
        headerPanel.add(new JLabel("Order ID"));
        headerPanel.add(new JLabel("Product"));
        headerPanel.add(new JLabel("Quantity"));
        headerPanel.add(new JLabel("Total Price"));
        headerPanel.add(new JLabel("Date"));
        mainPanel.add(headerPanel);

       
        for (Order order : orders) {
            JPanel orderPanel = new JPanel(new GridLayout(1, 5));
            orderPanel.add(new JLabel(order.getId()));
            orderPanel.add(new JLabel(order.getProduct().getName()));
            orderPanel.add(new JLabel(String.valueOf(order.getQuantity())));
            orderPanel.add(new JLabel(String.valueOf(order.getTotalPrice())));
            orderPanel.add(new JLabel(order.getDate().toString()));
            mainPanel.add(orderPanel);
        }

        
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane);

        setVisible(true);
    }

	public ManageOrders(List<Product> cartItems) {
		
	}
}
