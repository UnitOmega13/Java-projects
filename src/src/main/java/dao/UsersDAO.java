package dao;

import model.User;

import java.util.List;

public interface UsersDAO{

    void add(User user);
    List<User> getAll();
    User getUserById(long userId);
    void removeUser(User user);
    User getUserByEmail(String email);

}
