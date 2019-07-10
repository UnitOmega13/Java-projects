package dao;

import java.util.List;

public interface UsersDAO<User> {

    void add(User user);
    List<User> getAll();
    model.User getUserById(long userId);
    void removeUser(User user);

}
