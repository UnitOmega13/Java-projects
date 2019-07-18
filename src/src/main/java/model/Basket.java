package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Arrays;

public class Basket {
    private User user;
    private List<Optional<Product>> products = new ArrayList<Optional<Product>>();

    public Basket(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Optional<Product>> getProducts() {
        return products;
    }

    public void setProducts(Optional<Product> product) {
        products.add(product);
    }

    public int getSizeOfBasket() {
        return products.size();
    }

    public void resetBasket(){
        products = new ArrayList<Optional<Product>>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return Objects.equals(products, basket.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products);
    }

    @Override
    public String toString() {
        return Arrays.toString(products.toArray());
    }
}
