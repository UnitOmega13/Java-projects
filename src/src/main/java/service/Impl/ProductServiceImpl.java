package service.Impl;

import model.Product;
import service.DataBase;
import service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Override
    public void add(Product product) {
        DataBase.products.add(product);
    }

    @Override
    public List<Product> getAll() {
        return DataBase.products;
    }
}
