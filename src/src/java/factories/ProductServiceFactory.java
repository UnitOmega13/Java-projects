package factories;

import service.Impl.ProductServiceImpl;
import service.ProductService;

public class ProductServiceFactory {

    private static ProductService instance;

    private ProductServiceFactory() {
    }

    public static synchronized ProductService getInstance() {
        if (instance == null) {
            instance = new ProductServiceImpl();
        }
        return instance;
    }
}
