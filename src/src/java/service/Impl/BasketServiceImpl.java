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
        return getAllBaskets().stream()
                .filter(basket -> basket.getUser() == user)
                .findFirst();
    }

    @Override
    public void addProductToBasket(User user, Optional<Product> product) {
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

    @Override
    public double getPriceOfOrder(User user) {
        if (getUserBasket(user).isPresent()){
            return getUserBasket(user).get().getProducts()
                    .stream()
                    .mapToDouble(Product::getPrice)
                    .sum();
        }
        return 0;
    }
}
