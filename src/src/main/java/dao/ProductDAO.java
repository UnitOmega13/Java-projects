package dao;

import model.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductDAO {

    void add(Product product);
    List<Product> getAll();
    Optional<Product> getProduct(UUID productID);
    void removeProduct(Optional<Product> product);
}
