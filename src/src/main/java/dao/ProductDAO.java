package dao;

import model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDAO {

    void add(Product product);
    List<Product> getAll();
    Optional<Product> getProduct(long productID);
    void removeProduct(Optional<Product> product);
}
