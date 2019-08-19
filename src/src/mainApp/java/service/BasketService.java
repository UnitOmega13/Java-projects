package service;

import model.Basket;
import model.Product;
import model.User;

import java.util.List;
import java.util.Optional;

public interface BasketService {
    List<Basket> getAllBaskets();
    void createBasket(User user);
    Optional<Basket> getUserBasket(User user);
    void addProductToBasket(User user, Optional<Product> product);
    void clearBasket(User user);
    int getSizeOfBasket(User user);
    boolean checkUserBasket(User user);
}
