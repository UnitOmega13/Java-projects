package factories;

import dao.BasketDAO;
import dao.hibernate.BasketDaoHibernate;
import dao.impl.BasketDAOImpl;

public class BasketDAOFactory {
    private static BasketDAO instance;

    public BasketDAOFactory() {
    }

    public static synchronized BasketDAO getInstance() {
        if (instance == null) {
            instance = new BasketDaoHibernate();
        }
        return instance;
    }
}
