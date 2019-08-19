package dao;

import model.User;

import java.util.List;

public interface UsersDAO {

    void add(User user);
    List<User> getAll();
}
