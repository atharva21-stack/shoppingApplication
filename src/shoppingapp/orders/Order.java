package shoppingapp.orders;

import shoppingapp.catalog.Product;

import java.util.Date;
import java.util.List;

public class Order {
    private String id;
    private Product product;
    private int quantity;
    private double totalPrice;
    private Date date;
    private String username;
    private List<Product> products;

    public Order(String id, Product product, int quantity, double totalPrice, Date date) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.date = date;
    }
    
    public Order(String username, List<Product> products) {
        this.username = username;
        this.products = products;
    }

    public String getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getProductCount() {
        return products.size();
    }
    public double getTotalPrice() {
        return totalPrice;
    }

    public Date getDate() {
        return date;
    }
}
