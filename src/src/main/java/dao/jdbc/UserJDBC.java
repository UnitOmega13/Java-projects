package dao.jdbc;

import dao.UsersDAO;
import model.User;
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

public class UserJDBC implements UsersDAO {
    private static final Logger logger = Logger.getLogger(UserJDBC.class);
    private static final JDBCService daoService = new JDBCService();
    private static final String SQL_ADD_USER = "INSERT INTO users (email, password, role) " +
            "VALUES (?, ?, ?)";
    private static final String SQL_DELETE_USER = "DELETE FROM users WHERE id = (?)";
    private static final String SQL_GET_ALL_USER = "SELECT * FROM users";
    private static final String SQL_GET_USER_BY_EMAIL = "SELECT * FROM users WHERE email = (?)";
    private static final String SQL_GET_USER_BY_ID = "SELECT * FROM users WHERE id = (?)";
    private static final String SQL_UPDATE_USER = "UPDATE users SET email = (?), password = (?)" +
            "WHERE id = (?)";

    @Override
    public void add(User user) {
        try (Connection connection = daoService.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADD_USER);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getAccessRole());
            preparedStatement.executeUpdate();
            logger.info("User " + user + " added to DB");
        } catch (SQLException e) {
            logger.error("Error when try add users in DB", e);
        }
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = daoService.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_ALL_USER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                User user = new User (resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("role"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            logger.error("Error getting users", e);
        }
        return Collections.emptyList();
    }

    @Override
    public void updateUser(User user) {
        Optional<User> oldUserOptional = getUserById(user.getId());
        if (oldUserOptional.isPresent()) {
            User oldUser = oldUserOptional.get();
            oldUser.setLogin(user.getLogin());
            oldUser.setEmail(user.getEmail());
            oldUser.setPassword(user.getPassword());
            oldUser.setAccessRole(user.getAccessRole());
            logger.info(oldUser + " was updated");
        } else {
            logger.error("Error: user not found!");
        }
    }

    @Override
    public Optional<User> getUserById(Long userId) {
        try (Connection connection = daoService.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_USER_BY_ID);
            preparedStatement.setLong(1, userId);
            return getUserFromResultSet(preparedStatement.executeQuery());
        } catch (SQLException e) {
            logger.error("Error getting user by id", e);
        }
        return Optional.empty();
    }

    private Optional<User> getUserFromResultSet(ResultSet resultSet) {
        try {
            resultSet.next();
            User user = new User (resultSet.getLong("id"),
                    resultSet.getString("email"),
                    resultSet.getString("login"),
                    resultSet.getString("password"),
                    resultSet.getString("role"));
            return Optional.of(user);
        } catch (SQLException e) {
            logger.error("Error building user form resultSet", e);
        }
        return Optional.empty();
    }

    @Override
    public void removeUser(Long userId) {
        try (Connection connection = daoService.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_USER);
            preparedStatement.setString(1, String.valueOf(userId));
            preparedStatement.executeUpdate();
            logger.info(getUserById(userId) + " removed from DB");
        } catch (SQLException e) {
            logger.error("Error removing users", e);
        }
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        try (Connection connection = daoService.getConnection()) {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(SQL_GET_USER_BY_EMAIL);
            preparedStatement.setString(1, email);
            return getUserFromResultSet(preparedStatement.executeQuery());
        } catch (SQLException e) {
            logger.error("Error getting user by email", e);
        }
        return Optional.empty();
    }
}
