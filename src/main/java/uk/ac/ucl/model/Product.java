package uk.ac.ucl.model;

public class Product {
    private String name;
    private String type;
    private String productCode;
    private double price;

    public Product(String name, String type, String productCode, double price) {
        this.name = name;
        this.type = type;
        this.productCode = productCode;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getProductCode() {
        return productCode;
    }

    public double getPrice() {
        return price;
    }
}

