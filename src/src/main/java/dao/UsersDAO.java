package dao;

import java.util.List;

public interface UsersDAO<User> {

    void add(User user);
    List<User> getAll();
}
