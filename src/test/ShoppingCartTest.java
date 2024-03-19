package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import shoppingapp.catalog.Product;
import shoppingapp.shoppingcart.ShoppingCart;

public class ShoppingCartTest {

    @Test
    public void testAddProductToCart() {
        ShoppingCart cart = ShoppingCart.getInstance(); // Obtain instance using getInstance() method
        Product product = new Product("Bread", 2.99, "Groceries", "/shoppingapp/Images/bread.png");

        cart.addProduct(product);

        assertEquals(1, cart.getProductCount());
    }

    @Test
    public void testRemoveProductFromCart() {
        ShoppingCart cart = ShoppingCart.getInstance(); // Obtain instance using getInstance() method
        Product product = new Product("Milk", 1.99, "Groceries", "/shoppingapp/Images/milk.png");
        cart.addProduct(product);

        cart.removeProduct(product);

        assertEquals(0, cart.getProductCount());
    }

    @Test
    public void testCalculateTotalPrice() {
        ShoppingCart cart = ShoppingCart.getInstance(); // Obtain instance using getInstance() method
        Product product1 = new Product("Eggs", 3.49, "Groceries", "/shoppingapp/Images/eggs.png");
        Product product2 = new Product("Butter", 2.49, "Groceries", "/shoppingapp/Images/butter.png");
        cart.addProduct(product1);
        cart.addProduct(product2);

        assertEquals(5.98, cart.calculateTotalPrice());
    }
}
