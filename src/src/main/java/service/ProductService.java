package service;

import model.Product;

import java.util.List;

public interface ProductService<Product> {

    void add(Product product);
    List<Product> getAll();
    Product getProduct(Long productId);
    void removeProduct(Long productId);
}
