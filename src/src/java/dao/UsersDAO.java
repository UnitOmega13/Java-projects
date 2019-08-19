package dao;

import java.util.List;

public interface UsersDAO<User> {

    void add(User user);
    List<User> getAll();
    User getUserById(long userId);
    void removeUser(User user);
    model.User getUserByEmail(String email);

}
