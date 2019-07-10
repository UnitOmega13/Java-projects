package dao.impl;

import java.util.List;

import model.Product;
import org.apache.log4j.Logger;
import service.DataBase;

public class ProductDAOImpl implements ProductDAOImpl<Product> {

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
    public Product getProduct(Long productId) {
        return DataBase.products.stream().filter(e -> e.getId() == productId).findFirst().get();
    }

    @Override
    public void removeProduct(Long productId) {
        Product product = getProduct(productId);
        DataBase.products.remove(product);
        LOGGER.info("product " + product + " was deleted from the db");
    }
}