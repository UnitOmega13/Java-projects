package factories;

import dao.ProductDAO;
import dao.hibernate.ProductDaoHibernate;

public class ProductDAOFactory {

    private static ProductDAO instance;

    private ProductDAOFactory() {
    }

    public static synchronized ProductDAO getInstance() {
        if (instance == null) {
            instance = new ProductDaoHibernate();
        }
        return instance;
    }
}
