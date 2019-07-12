package service.Impl;

import dao.UsersDAO;
import factories.UserDAOFactory;
import model.User;
import service.UserService;

import java.util.List;

public class UserServiceInpl implements UserService {

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
    public User getUserById(long userID) {
        return usersDAO.getUserById(userID);
    }

    @Override
    public User getUserByEmail(String email) {
        return usersDAO.getUserByEmail(email);
    }

    @Override
    public void removeUser(long userID) {
        usersDAO.removeUser(getUserById(userID));
    }
}
