package service;

import dao.UsersDao;

public class UserDAOFactory {
    private static UsersDao instance;

    private UserDAOFactory() {
    }

    public static UsersDao getInstance() {
        if (instance == null) {
            instance = new UsersDao();
        }
        return instance;
    }
}
