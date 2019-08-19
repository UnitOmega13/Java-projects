package service.Impl;

import dao.OrderDetailsDAO;
import factories.OrderDetailsDAOFactory;
import model.OrderDetails;
import service.OrderService;

public class OrderDetailsServiceImpl implements OrderService {
    private static final OrderDetailsDAO orderDetailsDAO = OrderDetailsDAOFactory.getInstance();

    @Override
    public void addOrder(OrderDetails orderDetails) {
        orderDetailsDAO.addOrder(orderDetails);
    }
}
