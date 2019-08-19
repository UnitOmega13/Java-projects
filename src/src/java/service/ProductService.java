package service;

import java.util.List;

public interface ProductService<Product> {

    void add(Product product);
    List<Product> getAll();
    Product getProduct(long productID);
    void removeProduct(Product product);
}
