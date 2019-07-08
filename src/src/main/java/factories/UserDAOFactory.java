package factories;

import dao.impl.UsersDAO;

public class UserDAOFactory {

    private static UsersDAO instance;

    private UserDAOFactory() {
    }

    public static synchronized UsersDAO getInstance() {
        if (instance == null) {
            instance = new UsersDAO();
        }
        return instance;
    }

}
