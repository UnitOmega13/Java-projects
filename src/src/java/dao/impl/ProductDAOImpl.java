package dao.impl;

import java.util.List;

import dao.ProductDAO;
import model.Product;
import service.DataBase;

public class ProductDAOImpl implements ProductDAO {

    @Override
    public void add(Product product) {
        DataBase.products.add(product);
    }

    public List<Product> getAll() {
        return DataBase.products;
    }
}
