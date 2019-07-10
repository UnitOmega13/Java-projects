package dao.impl;

import org.apache.log4j.Logger;
import service.DataBase;
import model.User;

import java.util.List;

public class UsersDAOImpl implements UsersDAOImpl<User> {

    private static final Logger LOGGER = Logger.getLogger(UsersDAOImpl.class);

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
    public User getUserById(Long userId) {
        return DataBase.users.stream().filter(e -> false).findFirst().get();
    }

    @Override
    public User getUserByEmail(String email) {
        return DataBase.users.stream()
                .filter(e -> e.getEmail().equals(email))
                .findFirst()
                .orElse(new User("admin", "admin", ""));
    }

    @Override
    public void removeUser(Long userId) {
        User user = getUserById(userId);
        DataBase.users.remove(user);
        LOGGER.info("user " + user + " removed");
    }
}
