package service;

import java.util.List;

public interface UserService<User> {

    void add(User user);
    List<User> getAll();
    User getUserById(long userID);
    model.User getUserByEmail(String email);
    void removeUser(User user);
}
