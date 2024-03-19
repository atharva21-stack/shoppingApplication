package factory;

import shoppingapp.catalog.Product;

public class ProductFactory {
    public static Product createProduct(String type, String name, double price, String brand, String imagePath) {
        if ("grocery".equalsIgnoreCase(type)) {
            return new GroceryProduct(name, price, brand, imagePath);
        } else if ("electronics".equalsIgnoreCase(type)) {
            return new ElectronicsProduct(name, price, brand, imagePath);
        } else {
            throw new IllegalArgumentException("Invalid product type: " + type);
        }
    }
}
