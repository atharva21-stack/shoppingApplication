package shoppingapp.catalog;

public class Product {
    private String name;
    private double price;
    private String brand;
    private String imagePath; // New field for image path

    public Product(String name, double price, String brand, String imagePath) {
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.imagePath = imagePath; // Set image path
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
