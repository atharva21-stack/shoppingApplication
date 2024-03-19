package factory;

import shoppingapp.catalog.Product;

public class GroceryProduct extends Product {
    public GroceryProduct(String name, double price, String brand, String imagePath) {
        super(name, price, brand, imagePath);
    }
}
