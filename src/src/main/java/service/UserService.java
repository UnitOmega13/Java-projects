package service;

import model.User;

import java.util.List;

public interface UserService {

    void add(User user);
    List<User> getAll();
    User getUserById(long userID);
    User getUserByEmail(String email);
    void removeUser(User user);
}
