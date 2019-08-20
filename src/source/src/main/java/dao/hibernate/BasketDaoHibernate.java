package dao.hibernate;

import dao.BasketDAO;
import model.Basket;
import model.Product;
import model.User;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class BasketDaoHibernate implements BasketDAO {
    private static final Logger logger = Logger.getLogger(UserDaoHibernate.class);

    @Override
    public void createBasket(User user) {
        Transaction transaction = null;
        Basket basket = new Basket(user);
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(basket);
            transaction.commit();
            logger.info("Basket added");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error adding user basket", e);
        }
    }

    @Override
    public List<Basket> getAllBaskets() {
        return Collections.emptyList();
    }

    @Override
    public Optional<Basket> getUserBasket(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM basket where Users = :user");
            query.setParameter("user", user);
            Basket basket = (Basket) query.uniqueResult();
            return Optional.of(basket);
        } catch (Exception e) {
            logger.error("Error getting basket" + user, e);
        }
        return Optional.empty();
    }

    @Override
    public void addProductToBasket(User user, Product product) {
        Transaction transaction = null;
        Basket basket = getUserBasket(user).get();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            basket.setProducts(product);
            session.update(basket);
            transaction.commit();
            logger.info("Product added to basket");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error adding product to basket", e);
        }
    }

    @Override
    public void clearBasket(User user) {
        Transaction transaction = null;
        Basket basket = getUserBasket(user).get();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.remove(basket);
            transaction.commit();
            logger.info("Basket cleared");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error clearing basket", e);
        }
    }

    @Override
    public int getSizeOfBasket(User user) {
        if (getUserBasket(user).isPresent()) {
            Basket basket = getUserBasket(user).get();
            return basket.getProducts().size();
        } else {
            return 0;
        }
    }

    @Override
    public boolean checkUserBasket(User user) {
        return getUserBasket(user).isPresent();
    }

    public double getSumOfOrder(User user) {
        if (getUserBasket(user).isPresent()) {
            return getUserBasket(user).get().getProducts()
                    .stream()
                    .mapToDouble(Product::getPrice)
                    .sum();
        } else {
            return 0;
        }
    }
}
