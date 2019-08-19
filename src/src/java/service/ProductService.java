package service;

import model.Product;

import java.util.List;

public interface ProductService<Product> {

    void add(Product product);
    List<Product> getAll();
    void removeProduct(Product product);
}
