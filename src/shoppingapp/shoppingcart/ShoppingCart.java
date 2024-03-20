package shoppingapp.shoppingcart;

import java.util.ArrayList;
import java.util.List;
import shoppingapp.catalog.Product;

public class ShoppingCart {
    private List<Product> items;
    private String customerName;
    private String customerEmail;
    private static ShoppingCart instance;
   

    private ShoppingCart() {
        items = new ArrayList<>();
    }
    public ShoppingCart(List<Product> items, String customerName, String customerEmail) {
        this.items = items;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
    }

    public static ShoppingCart getInstance() {
        if (instance == null) {
            instance = new ShoppingCart();
        }
        return instance;
    }

    public void addProduct(Product product) {
        items.add(product);
    }

    public void removeProduct(Product product) {
        items.remove(product);
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Product item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    public int getProductCount() {
        return items.size();
    }
}
