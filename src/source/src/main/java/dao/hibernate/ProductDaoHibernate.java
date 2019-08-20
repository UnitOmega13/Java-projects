package dao.hibernate;

import dao.ProductDAO;
import model.Product;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ProductDaoHibernate implements ProductDAO {
    private static final Logger logger = Logger.getLogger(ProductDaoHibernate.class);

    @Override
    public void add(Product product) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
            logger.info("Product added");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error adding product", e);
        }
    }

    @Override
    public List<Product> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM product", Product.class).list();
        } catch (Exception e) {
            logger.error("error when get all product in hibernate", e);
        }
        return Collections.emptyList();
    }

    @Override
    public Optional<Product> getProduct(Long productID) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Product product = session.get(Product.class, productID);
            if (Objects.isNull(product)) {
                return Optional.empty();
            } else {
                return Optional.of(product);
            }
        } catch (Exception e) {
            logger.error("error getting product", e);
        }
        return Optional.empty();
    }

    @Override
    public void removeProduct(Long productID) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            if (getProduct(productID).isPresent()) {
                session.delete(getProduct(productID).get());
            }
            transaction.commit();
            logger.info("Product removed");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error removing product", e);
        }
    }

    @Override
    public void updateProduct(Product oldProduct, Product newProduct) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update("product", newProduct);
            transaction.commit();
            logger.info("Product updated");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error updating product", e);
        }
    }
}
