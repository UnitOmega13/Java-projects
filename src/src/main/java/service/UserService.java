package service;

import model.User;

import java.util.List;

public interface UserService<User> {

    void add(User user);
    List<User> getAll();
    User getUserById(Long userId);
    User getUserByEmail(String email);
    void removeUser(Long userId);
}
