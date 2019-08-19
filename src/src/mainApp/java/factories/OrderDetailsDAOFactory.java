package factories;

import dao.OrderDetailsDAO;
import dao.hibernate.OrderDaoHibernate;

public class OrderDetailsDAOFactory {
    private static OrderDetailsDAO instance;

    public OrderDetailsDAOFactory() {
    }

    public static synchronized OrderDetailsDAO getInstance() {
        if (instance == null) {
            instance = new OrderDaoHibernate();
        }
        return instance;
    }
}
