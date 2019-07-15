package dao.impl;

import dao.UsersDAO;
import service.DataBase;
import model.User;

import java.util.List;

public class UsersDAOImpl implements UsersDAO {

    @Override
    public void add(User user) {
        DataBase.users.add(user);
    }

    @Override
    public List getAll() {
        return DataBase.users;
    }
}
