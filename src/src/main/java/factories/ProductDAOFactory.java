package factories;

import dao.ProductDAOInterface;
import dao.impl.ProductDAO;

public class ProductDAOFactory {

    private static ProductDAOInterface instance;

    private ProductDAOFactory() {
    }

    public static synchronized ProductDAOInterface getInstance() {
        if (instance == null) {
            instance = new ProductDAO();
        }
        return instance;
    }
}
