package dao;

import java.util.List;

public interface ProductDAO<Product> {

    void add(Product product);
    List<Product> getAll();
    Product getProduct(Long productId);
    void removeProduct(Long productId);
}
