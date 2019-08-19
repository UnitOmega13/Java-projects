package main.dao;

import java.util.List;

public interface UsersDAOInterface<User> {

    void add(User user);
    List<User> getAll();
}
