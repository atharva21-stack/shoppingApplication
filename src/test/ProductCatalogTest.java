package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import shoppingapp.catalog.Product;
import shoppingapp.orders.Order;
import shoppingapp.shoppingcart.ShoppingCart;
import shoppingapp.authentication.UserAuthentication;
import shoppingapp.catalog.Product;



public class ProductCatalogTest {

    @Test
    public void testProductCreation() {
        Product product = new Product("Bread", 2.99, "Groceries", "/shoppingapp/Images/bread.png");

        assertEquals("Bread", product.getName());
        assertEquals(2.99, product.getPrice());
        assertEquals("Groceries", product.getBrand());
        assertEquals("/shoppingapp/Images/bread.png", product.getImagePath());
    }
}
