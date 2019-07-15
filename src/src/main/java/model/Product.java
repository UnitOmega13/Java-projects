package model;

import java.util.Objects;
import java.util.UUID;

public class Product {

    private UUID id;
    private String name;
    private String description;
    private double price;

    public Product(UUID id, String name, String img, double price) {
        this.id = id;
        this.name = name;
        this.description = img;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String getImg() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Product product = (Product) object;
        if (getId() != product.getId()) return false;
        if (Double.compare(product.getPrice(), getPrice()) != 0) return false;
        if (getName() != null ? !getName().equals(product.getName()) : product.getName() != null) return false;
        return getImg() != null ? getImg().equals(product.getImg()) : product.getImg() == null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", img='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
