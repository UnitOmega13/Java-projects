package service;

import Entiny.User;
import dao.UsersDao;

public class AccountService {
    private User user;
    private boolean isLogin;
    private static AccountService accountService;
    private UsersDao userDAO = UsersDao.instance();

    public static AccountService instance() {
        if (accountService == null) {
            accountService = new AccountService();
        }
        return accountService;
    }

    private AccountService() {
    }

    public boolean signIn(String login, String password) {
        User userDataBase = UsersDao.instance().getUserByLogin(login);
        if (userDataBase != null) {
            if (userDataBase.getPassword().equals(password)) {
                user = userDataBase;
                isLogin = true;
            }
        }
        return isLogin;
    }

    public boolean signUp(String login, String password, String passwordRepeat) {
        if (password.equals(passwordRepeat)) {
            return userDAO.addUser(login, password);
        }
        return false;
    }

    public User getUser() {
        return user;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void endSession() {
        isLogin = false;
        user = null;
    }
}
