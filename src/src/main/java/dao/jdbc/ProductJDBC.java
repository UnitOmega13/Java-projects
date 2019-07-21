package dao.jdbc;

import dao.ProductDAO;
import model.Product;
import org.apache.log4j.Logger;
import utils.JDBCService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ProductJDBC implements ProductDAO {
    private static final Logger logger = Logger.getLogger(ProductJDBC.class);
    private static final JDBCService jdbcService = new JDBCService();
    private static final String SQL_ADD_PRODUCT = "INSERT INTO products (product_name, " +
            "description, price) VALUES (?, ?, ?)";
    private static final String SQL_DELETE_PRODUCT = "DELETE FROM products WHERE id = (?)";
    private static final String SQL_GET_ALL_PRODUCTS = "SELECT * FROM products";
    private static final String SQL_GET_PRODUCT_BY_ID = "SELECT * FROM products WHERE id = (?)";
    private static final String SQL_UPDATE_PRODUCT = "UPDATE products SET product_name = (?)," +
            "description = (?), price = (?) WHERE id = (?)";

    @Override
    public void add(Product product) {
        try (Connection connection = jdbcService.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADD_PRODUCT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setString(3, String.valueOf(product.getPrice()));
            preparedStatement.executeUpdate();
            logger.info("Product " + product + " added to DB");
        } catch (SQLException e) {
            logger.error("Error adding product", e);
        }
    }

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = jdbcService.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_ALL_PRODUCTS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product (resultSet.getLong("id"),
                        resultSet.getString("product_name"),
                        resultSet.getString("description"),
                        resultSet.getDouble("price"));
                products.add(product);
            }
            return products;
        } catch (SQLException e) {
            logger.error("Error getting products", e);
        }
        return Collections.emptyList();
    }

    @Override
    public Optional<Product> getProduct(Long productID) {
        try (Connection connection = jdbcService.getConnection()) {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(SQL_GET_PRODUCT_BY_ID);
            preparedStatement.setString(1, String.valueOf(productID));
            return getProductFromResult(preparedStatement.executeQuery());
        } catch (SQLException e) {
            logger.error("Error getting product by id", e);
        }
        return Optional.empty();
    }

    private Optional<Product> getProductFromResult(ResultSet resultSet) {
        try {
            resultSet.next();
            Product product = new Product (resultSet.getLong("id"),
                    resultSet.getString("product_name"),
                    resultSet.getString("description"),
                    resultSet.getDouble("price"));
            return Optional.of(product);
        } catch (SQLException e) {
            logger.error("Error building product form resultSet", e);
        }
        return Optional.empty();
    }

    @Override
    public void removeProduct(Long productID) {
        try (Connection connection = jdbcService.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_PRODUCT);
            preparedStatement.setString(1, String.valueOf(productID));
            preparedStatement.executeUpdate();
            logger.info("Product " + getProduct(productID) + " deleted from DB");
        } catch (SQLException e) {
            logger.error("Error removing product", e);
        }
    }

    @Override
    public void updateProduct(Product oldProduct, Product newProduct) {
        try (Connection connection = jdbcService.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_PRODUCT);
            preparedStatement.setString(1, newProduct.getName());
            preparedStatement.setString(2, newProduct.getDescription());
            preparedStatement.setString(3, String.valueOf(newProduct.getPrice()));
            preparedStatement.setString(4, String.valueOf(oldProduct.getId()));
            preparedStatement.executeUpdate();
            logger.info("Product " + oldProduct.getId() + " update in DB");
        } catch (SQLException e) {
            logger.error("Error when try update product in DB", e);
        }
    }
}
