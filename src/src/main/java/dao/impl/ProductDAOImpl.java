package dao.impl;

import java.util.List;

import dao.ProductDAO;
import model.Product;
import org.apache.log4j.Logger;
import service.DataBase;

public class ProductDAOImpl implements ProductDAO {

    private static final Logger LOGGER = Logger.getLogger(ProductDAOImpl.class);

    @Override
    public void add(Product product) {
        DataBase.products.add(product);
        LOGGER.info("product " + product + " added");
    }

    public List<Product> getAll() {
        return DataBase.products;
    }

    @Override
    public Product getProduct(long productID) {
        return DataBase.products.get(Math.toIntExact(productID));
    }

    @Override
    public void removeProduct(Product product) {
        DataBase.products.remove(product);
        LOGGER.info("product " + product + " was deleted from the db");
    }
}
