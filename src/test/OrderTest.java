package test;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import shoppingapp.catalog.Product;
import shoppingapp.orders.Order;
import shoppingapp.shoppingcart.ShoppingCart;
import shoppingapp.authentication.UserAuthentication;
import shoppingapp.catalog.Product;




public class OrderTest {

    @Test
    public void testOrderCreation() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Bread", 2.99, "Groceries", "/shoppingapp/Images/bread.png"));
        products.add(new Product("Milk", 1.99, "Groceries", "/shoppingapp/Images/milk.png"));

        Order order = new Order("user123", products);

        assertEquals("user123", order.getUsername());
        assertEquals(2, order.getProductCount());
        assertEquals(4.98, order.getTotalPrice());
    }
}
