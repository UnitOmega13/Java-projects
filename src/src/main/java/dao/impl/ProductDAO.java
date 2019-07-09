package dao.impl;

import java.util.List;

import model.Product;
import service.DataBase;

public class ProductDAO implements dao.ProductDAO {

    @Override
    public void add(Product item) {
        DataBase.products.add((Product) item);
    }

    public List<Product> getAll() {
        return DataBase.products;
    }
}
