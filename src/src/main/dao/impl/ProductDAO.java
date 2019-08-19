package main.dao.impl;

import java.util.List;

import main.dao.ProductDAOInterface;
import main.model.Product;
import main.service.DataBaseService;

public class ProductDAO implements ProductDAOInterface {

    public ProductDAO() {
    }

    @Override
    public void add(Object item) {
        DataBaseService.products.add((Product) item);
    }

    public List<Product> getAll() {
        return DataBaseService.products;
    }
}
