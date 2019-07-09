package service.Impl;

import dao.UsersDAO;
import factories.UserDAOFactory;
import model.User;
import service.UserService;

import java.util.List;

public class UserServiceInpl implements UserService<User> {

    private UsersDAO usersDAO = UserDAOFactory.getInstance();

    @Override
    public void add(User user) {
        usersDAO.add(user);
    }

    @Override
    public List<User> getAll() {
        return usersDAO.getAll();
    }

    @Override
    public User getUserById(Long userId) {
        return (User) usersDAO.getUserById(userId);
    }

    @Override
    public User getUserByEmail(String email) {
        return (User) usersDAO.getUserByEmail(email);
    }

    @Override
    public void removeUser(Long userId) {
        usersDAO.removeUser(userId);
    }
}
