package service.Impl;

import dao.BasketDAO;
import factories.BasketDAOFactory;
import model.Basket;
import model.Product;
import model.User;
import service.BasketService;

import java.util.List;
import java.util.Optional;

public class BasketServiceImpl implements BasketService {
    private static final BasketDAO basketDAO = BasketDAOFactory.getInstance();

    @Override
    public List<Basket> getAllBaskets() {
        return basketDAO.getAllBaskets();
    }

    @Override
    public void createBasket(User user) {
        basketDAO.createBasket(user);
    }

    @Override
    public Optional<Basket> getUserBasket(User user) {
        return basketDAO.getUserBasket(user);
    }

    @Override
    public void addProductToBasket(User user, Optional<Product> product) {
        basketDAO.addProductToBasket(user, product);
    }

    @Override
    public void clearBasket(User user) {
        basketDAO.clearBasket(user);
    }

    @Override
    public int getSizeOfBasket(User user) {
        return basketDAO.getSizeOfBasket(user);
    }

    @Override
    public boolean checkUserBasket(User user) {
        return basketDAO.checkUserBasket(user);
    }
}
