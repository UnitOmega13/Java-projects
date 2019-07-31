package dao.impl;

import dao.BasketDAO;
import model.Basket;
import model.Product;
import model.User;
import org.apache.log4j.Logger;
import storage.DataBase;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Basket> getUserBasket(User user) {
        return getAllBaskets().stream()
                .filter(basket -> basket.getUser().equals(user))
                .findFirst();
    }

    @Override
    public void addProductToBasket(User user, Product product) {
        if (getUserBasket(user).isPresent()){
            getUserBasket(user).get().setProducts(product);
        }
    }

    @Override
    public void clearBasket(User user) {
        if (getUserBasket(user).isPresent()){
            getUserBasket(user).get().resetBasket();
        }
    }

    @Override
    public int getSizeOfBasket(User user) {
        if (getUserBasket(user).isPresent()) {
            return getUserBasket(user).get().getSizeOfBasket();
        }
        return 0;
    }

    @Override
    public boolean checkUserBasket(User user) {
        return getUserBasket(user).isPresent();
    }
}
