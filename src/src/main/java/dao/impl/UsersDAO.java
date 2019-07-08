package dao.impl;

import dao.UsersDAOInterface;
import service.DataBase;
import model.User;

import java.util.List;

public class UsersDAO implements UsersDAOInterface {

    public UsersDAO() {
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
