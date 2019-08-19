package dao.impl;

import dao.OrderDetailsDAO;
import model.OrderDetails;
import storage.DataBase;

public class OrderDetailsDAOImpl implements OrderDetailsDAO {
    @Override
    public void addOrder(OrderDetails orderDetails) {
        DataBase.orders.add(orderDetails);
    }
}
