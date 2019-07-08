package service.Impl;

import model.User;
import service.DataBase;
import service.UserService;

import java.util.List;

public class UserServiceInpl implements UserService {
    @Override
    public void add(User user) {
        DataBase.users.add(user);
    }

    @Override
    public List<User> getAll() {
        return DataBase.users;
    }
}
