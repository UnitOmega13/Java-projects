package factories;

import dao.UsersDAO;
import dao.hibernate.UserDaoHibernate;
import dao.impl.UsersDAOImpl;

public class UserDAOFactory {

    private static UsersDAO instance;

    private UserDAOFactory() {
    }

    public static synchronized UsersDAO getInstance() {
        if (instance == null) {
            instance = new UserDaoHibernate();
        }
        return instance;
    }
}
