package service.Impl;

import dao.OrderDetailsDAO;
import factories.OrderDetailsDAOFactory;
import model.OrderDetails;
import service.OrderService;

public class OrserDetailsServiceImpl implements OrderService {
    private static final OrderDetailsDAO orderDetailsDAO = OrderDetailsDAOFactory.getInstance();

    @Override
    public void addOrder(OrderDetails orderDetails) {
        orderDetailsDAO.addOrder(orderDetails);
    }
}
