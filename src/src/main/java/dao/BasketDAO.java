package dao;

import model.Basket;
import model.User;

import java.util.List;

public interface BasketDAO {
    void createBasket(User user);
    List<Basket> getAllBaskets();
}
