package factories;

import dao.UsersDAOInterface;
import dao.impl.UsersDAO;

public class UserDAOFactory {

    private static UsersDAOInterface instance;

    private UserDAOFactory() {
    }

    public static synchronized UsersDAOInterface getInstance() {
        if (instance == null) {
            instance = new UsersDAO();
        }
        return instance;
    }
}
