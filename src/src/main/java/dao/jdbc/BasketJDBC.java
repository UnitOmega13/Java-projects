package dao.jdbc;

import dao.BasketDAO;
import model.Basket;
import model.Product;
import model.User;
import org.apache.log4j.Logger;
import utils.JDBCService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class BasketJDBC implements BasketDAO {
    private static final Logger logger = Logger.getLogger(ProductJDBC.class);
    private static final JDBCService jdbcService = new JDBCService();
    private static final String SQL_ADD_BASKET = "INSERT INTO basket (userID) VALUES (?)";
    private static final String SQL_ADD_PRODUCT_TO_BASKET = "INSERT INTO basket (userID,productID) VALUES (?, ?)";
    private static final String SQL_SIZE_BASKET = "SELECT COUNT(*) FROM basket WHERE userID = (?)";
    private static final String SQL_CHECK_BASKET = "SELECT EXISTS(SELECT * FROM basket WHERE userID = (?))";
    private static final String SQL_SUM_OF_ORDER = "SELECT SUM(price) FROM product_basket INNER " +
            "JOIN products ON basket.productID = products.productID WHERE userID = (?)";
    private static final String SQL_RESET_BASKET = "DELETE basket.* FROM basket ";
    private static final String SQL_GET_BASKET_BY_USER = "SELECT * FROM basket " +
            "INNER JOIN products ON basket.productID = products.productID " +
            "WHERE basket.userID = (?)";

    @Override
    public void createBasket(User user) {
        try (Connection connection = jdbcService.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADD_BASKET);
            preparedStatement.setString(1, String.valueOf(user.getId()));
            preparedStatement.executeUpdate();
            logger.info("Basket for " + user + " added");
        } catch (SQLException e) {
            logger.error("Error adding basket to DB", e);
        }
    }

    @Override
    public List<Basket> getAllBaskets() {
        return Collections.emptyList();
    }

    @Override
    public Optional<Basket> getUserBasket(User user) {
        try (Connection connection = jdbcService.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_BASKET_BY_USER);
            preparedStatement.setLong(1, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            Basket basket = new Basket(user);
            while (resultSet.next()) {
                Product product = new Product(resultSet.getLong("productID"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getDouble("price"));
                basket.setProducts(product);
            }
            logger.info("Basket for " + user + " added");
            return Optional.of(basket);
        } catch (SQLException e) {
            logger.error("Error getting basket", e);
        }
        return Optional.empty();
    }

    @Override
    public void addProductToBasket(User user, Product product) {
        try (Connection connection = jdbcService.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADD_PRODUCT_TO_BASKET);
            preparedStatement.setString(1, String.valueOf(user.getId()));
            preparedStatement.setString(2, String.valueOf(product.getId()));
            preparedStatement.executeUpdate();
            logger.info("Product " + product.getId() + " added to user basket " + user.getId());
        } catch (SQLException e) {
            logger.error("Error adding product to basket", e);
        }
    }

    @Override
    public void clearBasket(User user) {
        try (Connection connection = jdbcService.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_RESET_BASKET);
            preparedStatement.setLong(1, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error clearing basket", e);
        }
    }

    @Override
    public int getSizeOfBasket(User user) {
        try (Connection connection = jdbcService.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SIZE_BASKET);
            preparedStatement.setString(1, String.valueOf(user.getId()));
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt("COUNT(*)");
        } catch (SQLException e) {
            logger.error("Error finding count of basket", e);
        }
        return 0;
    }

    @Override
    public boolean checkUserBasket(User user) {
        try (Connection connection = jdbcService.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_CHECK_BASKET);
            preparedStatement.setString(1, String.valueOf(user.getId()));
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1) == 1;
        } catch (SQLException e) {
            logger.error("Error finding size of basket", e);
        }
        return false;
    }

    @Override
    public double getSumOfOrder(User user) {
        try (Connection connection = jdbcService.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SUM_OF_ORDER);
            preparedStatement.setString(1, String.valueOf(user.getId()));
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getDouble("SUM(price)");
        } catch (SQLException e) {
            logger.error("Error finding sum of order", e);
        }
        return 0;
    }
}
