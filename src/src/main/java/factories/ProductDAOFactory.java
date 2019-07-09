package factories;

import dao.ProductDAO;

public class ProductDAOFactory {

    private static ProductDAO instance;

    private ProductDAOFactory() {
    }

    public static synchronized ProductDAO getInstance() {
        if (instance == null) {
            instance = new dao.impl.ProductDAO();
        }
        return instance;
    }
}
