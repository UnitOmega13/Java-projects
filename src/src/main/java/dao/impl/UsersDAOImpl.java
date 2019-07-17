package dao.impl;

import dao.UsersDAO;
import org.apache.log4j.Logger;
import storage.DataBase;
import model.User;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

public class UsersDAOImpl implements UsersDAO {

    private static final Logger LOGGER = Logger.getLogger(DataBase.class);

    @Override
    public void add(User user) {
        DataBase.users.add(user);
        LOGGER.info("user " + user + " added");
    }

    @Override
    public List getAll() {
        return DataBase.users;
    }

    @Override
    public Optional<User> getUserById(long userId) {
        return DataBase.users.stream()
                .filter(e -> e.getId() == (userId))
                .findFirst();
    }

    @Override
    public void removeUser(long userId) {
        Optional<User> optionalUser = getUserById(userId);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            DataBase.users.remove(user);
            LOGGER.info("user " + user + " deleted");
        } else {
            LOGGER.warn("Incorrect userId was inputted");
            throw new NoSuchElementException("User " + userId + " does not exist");
        }
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return DataBase.users.stream()
                .filter(e -> e.getEmail().equals(email))
                .findFirst();
    }
}
