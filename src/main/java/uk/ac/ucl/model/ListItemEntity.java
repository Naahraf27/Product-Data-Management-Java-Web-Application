// ListItemEntity.java
package uk.ac.ucl.model;

public class ListItemEntity {
    private String name;
    private String type;
    private String productCode;
    private double price;

    public ListItemEntity(String name, String type, String productCode, double price) {
        this.name = name;
        this.type = type;
        this.productCode = productCode;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
