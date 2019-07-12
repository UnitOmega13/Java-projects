package dao;

import model.Product;

import java.util.List;

public interface ProductDAO {

    void add(Product product);
    List<Product> getAll();
    model.Product getProduct(long productID);
    void removeProduct(Product product);
}
