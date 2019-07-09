package factories;

import dao.UsersDAO;

public class UserDAOFactory {

    private static UsersDAO instance;

    private UserDAOFactory() {
    }

    public static UsersDAO getInstance() {
        if (instance == null) {
            instance = new dao.impl.UsersDAO();
        }
        return instance;
    }
}
