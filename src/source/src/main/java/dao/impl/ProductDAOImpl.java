package dao.impl;

import dao.ProductDAO;
import model.Product;
import org.apache.log4j.Logger;
import storage.DataBase;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
    public Optional<Product> getProduct(Long productID) {
        return DataBase.products.stream()
                .filter(e -> Objects.equals(e.getId(), productID))
                .findFirst();
    }

    @Override
    public void removeProduct(Long productID) {
        DataBase.products.remove(getProduct(productID));
        LOGGER.info("product " + productID + " was deleted");
    }

    @Override
    public void updateProduct(Product oldProduct, Product newProduct) {

    }
}
