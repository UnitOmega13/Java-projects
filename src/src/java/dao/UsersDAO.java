package dao;

import model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsersDAO{

    void add(User user);
    List<User> getAll();
    Optional<User> getUserById(long userId);
    void removeUser(long userId);
    Optional<User> getUserByEmail(String email);

}
