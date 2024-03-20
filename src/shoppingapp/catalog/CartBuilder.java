package shoppingapp.catalog;

import java.util.ArrayList;
import java.util.List;

import shoppingapp.shoppingcart.ShoppingCart;

public class CartBuilder {
    private List<Product> cartItems;
    private String customerName;
    private String customerEmail;

    public CartBuilder() {
        this.cartItems = new ArrayList<>();
    }

    public CartBuilder addItem(Product product) {
        this.cartItems.add(product);
        return this;
    }

    public CartBuilder removeItem(Product product) {
        this.cartItems.remove(product);
        return this;
    }

    public CartBuilder setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public CartBuilder setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
        return this;
    }

    public ShoppingCart build() {
        return new ShoppingCart(cartItems, customerName, customerEmail);
    }
}