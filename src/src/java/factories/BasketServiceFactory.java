package factories;

import service.BasketService;
import service.Impl.BasketServiceImpl;

public class BasketServiceFactory {
    private static BasketService instance;

    public BasketServiceFactory() {
    }

    public static synchronized BasketService getInstance() {
        if (instance == null) {
            instance = new BasketServiceImpl();
        }
        return instance;
    }
}
