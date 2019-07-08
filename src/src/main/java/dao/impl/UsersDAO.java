package dao.impl;

import dao.UsersDAOInterface;
import service.DataBase;
import model.User;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class UsersDAO implements UsersDAOInterface {

    public UsersDAO() {
    }

    public static User create(String email, String login, String password) {
        if (Objects.isNull(email)
                || Objects.isNull(login)
                || Objects.isNull(password)) {
            throw new NoSuchElementException("Wrong parameters, try again!");
        }
        return new User(email, login, password);
    }

    @Override
    public void add(Object o) {
        DataBase.users.add((User) o);
    }

    @Override
    public List getAll() {
        return DataBase.users;
    }
}
