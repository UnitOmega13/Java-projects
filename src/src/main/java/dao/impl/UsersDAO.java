package dao.impl;

import service.DataBase;
import model.User;

import java.util.List;

public class UsersDAO implements dao.UsersDAO {

    @Override
    public void add(User o) {
        DataBase.users.add((User) o);
    }

    @Override
    public List getAll() {
        return DataBase.users;
    }
}
