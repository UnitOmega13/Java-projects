package main.dao;

import java.util.List;

public interface ProductDAOInterface<Product> {

    void add(Product product);
    List<Product> getAll();
}
