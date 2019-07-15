package model;

public class Product {

    private Long id;
    private String name;
    private String description;
    private double price;

    public Product(Long id, String name, String img, double price) {
        this.id = id;
        this.name = name;
        this.description = img;
        this.price = price;
    }

    private long getId() {
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
        long result;
        long temp;
        result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getImg() != null ? getImg().hashCode() : 0);
        temp = Double.doubleToLongBits(getPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result;
        return Math.toIntExact(result);
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
