package factories;

import service.Impl.OrserDetailsServiceImpl;
import service.OrderService;

public class OrderDetailsFactory {
    private static OrderService instance;

    public OrderDetailsFactory() {
    }

    public static synchronized OrderService getInstance() {
        if (instance == null) {
            instance = new OrserDetailsServiceImpl();
        }
        return instance;
    }
}
