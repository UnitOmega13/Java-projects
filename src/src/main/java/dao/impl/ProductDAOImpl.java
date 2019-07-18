package dao.impl;

import java.util.List;
import java.util.Optional;

import dao.ProductDAO;
import model.Product;
import org.apache.log4j.Logger;
import storage.DataBase;

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
    public Optional<Product> getProduct(long productID) {
        return DataBase.products.stream()
                .filter(e -> e.getId().equals(productID))
                .findFirst();
    }

    @Override
    public void removeProduct(Optional<Product> product) {
        DataBase.products.remove(product);
        LOGGER.info("product " + product + " was deleted");
    }
}
