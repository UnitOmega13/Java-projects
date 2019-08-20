package dao.jdbc;

import dao.OrderDetailsDAO;
import model.OrderDetails;
import org.apache.log4j.Logger;
import utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderJDBC implements OrderDetailsDAO {
    private static final Logger logger = Logger.getLogger(ProductJDBC.class);
    private static final String SQL_ADD_ORDER = "INSERT INTO orders (first_name, " +
            "last_name, email, street, country, city, phone_number) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?)";
    @Override
    public void addOrder(OrderDetails orderDetails) {
        try (Connection connection = JDBCUtil.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADD_ORDER);
            preparedStatement.setString(1, orderDetails.getName());
            preparedStatement.setString(2, orderDetails.getLastName());
            preparedStatement.setString(3, orderDetails.getEmail());
            preparedStatement.setString(4, orderDetails.getStreet());
            preparedStatement.setString(5, orderDetails.getCountry());
            preparedStatement.setString(6, orderDetails.getCity());
            preparedStatement.setString(7, orderDetails.getPhoneNumber());
            preparedStatement.executeUpdate();
            logger.info("Order " + orderDetails.toString() + " added to DB");
        } catch (SQLException e) {
            logger.error("Error adding order", e);
        }
    }
}
