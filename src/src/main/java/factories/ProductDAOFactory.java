package factories;

import dao.impl.ProductDAO;

public class ProductDAOFactory {

    private static ProductDAO instance;

    private ProductDAOFactory() {
    }

    public static synchronized ProductDAO getInstance() {
        if (instance == null) {
            instance = new ProductDAO();
        }
        return instance;
    }
}
