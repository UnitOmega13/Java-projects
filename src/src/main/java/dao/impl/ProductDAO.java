package dao.impl;

import java.util.List;

import dao.ProductDAOInterface;
import model.Product;
import service.DataBaseService;

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
