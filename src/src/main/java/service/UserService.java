package service;

import model.User;

import java.util.List;

public interface UserService<User> {

    void add(User user);
    List<User> getAll();
    void removeUser(User user);
}
