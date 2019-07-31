package dao.impl;

import dao.UsersDAO;
import org.apache.log4j.Logger;
import storage.DataBase;
import model.User;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

public class UsersDAOImpl implements UsersDAO {
    private static final Logger logger = Logger.getLogger(DataBase.class);

    @Override
    public void add(User user) {
        DataBase.users.add(user);
        logger.info("user " + user + " added");
    }

    @Override
    public List getAll() {
        return DataBase.users;
    }

    @Override
    public Optional<User> getUserById(Long userId) {
        return DataBase.users.stream()
                .filter(e -> Objects.equals(e.getId(), userId))
                .findFirst();
    }

    @Override
    public void removeUser(Long userId) {
        Optional<User> optionalUser = getUserById(userId);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            DataBase.users.remove(user);
            logger.info("user " + user + " deleted");
        } else {
            logger.warn("Incorrect userId was inputted");
            throw new NoSuchElementException("User " + userId + " does not exist");
        }
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return DataBase.users.stream()
                .filter(e -> e.getEmail().equals(email))
                .findFirst();
    }

    @Override
    public void updateUser(User oldUser) {

    }
}
