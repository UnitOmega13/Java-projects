package dao;

import java.util.List;

public interface ProductDAO<Product> {

    void add(Product product);
    List<Product> getAll();
    void removeProduct(Product product);
}
