package dao.impl;

import dao.UsersDAO;
import org.apache.log4j.Logger;
import service.DataBase;
import model.User;

import java.util.List;

public class UsersDAOImpl implements UsersDAO<User> {

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
    public User getUserById(long userId) {
        return DataBase.users.get(Math.toIntExact(userId));
    }

    @Override
    public void removeUser(User user) {
        DataBase.users.remove(user);
        LOGGER.info("user " + user + " removed");
    }
}
