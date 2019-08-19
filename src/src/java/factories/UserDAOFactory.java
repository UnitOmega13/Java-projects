package factories;

import dao.UsersDAO;
import dao.impl.UsersDAOImpl;

public class UserDAOFactory {

    private static UsersDAO instance;

    private UserDAOFactory() {
    }

    public static synchronized UsersDAO getInstance() {
        if (instance == null) {
            instance = new UsersDAOImpl();
        }
        return instance;
    }
}
