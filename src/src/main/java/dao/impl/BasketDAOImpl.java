package dao.impl;

import dao.BasketDAO;
import model.Basket;
import model.User;
import org.apache.log4j.Logger;
import storage.DataBase;

import java.util.List;

public class BasketDAOImpl implements BasketDAO {
    private static final Logger logger = Logger.getLogger(ProductDAOImpl.class);

    @Override
    public void createBasket(User user) {
        DataBase.baskets.add(new Basket(user));
        logger.info("Basket created");
    }

    @Override
    public List<Basket> getAllBaskets() {
        return DataBase.baskets;
    }
}
