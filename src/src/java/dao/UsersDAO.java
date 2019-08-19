package dao;

import model.User;

import java.util.List;
import java.util.Optional;

public interface UsersDAO {

    void add(User user);
    List<User> getAll();
    Optional<User> getUserById(Long userId);
    void removeUser(Long userId);
    Optional<User> getUserByEmail(String email);

}
