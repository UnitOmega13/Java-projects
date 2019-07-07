package service;

import model.User;
import dao.impl.UsersDAO;
import factories.UserDAOFactory;

public class AccountService {

    private User user;

    public AccountService() {
    }

    public User getUser() {
        return user;
    }

}
