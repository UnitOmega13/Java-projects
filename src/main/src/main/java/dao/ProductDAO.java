package dao;

import java.util.List;

import Entiny.Product;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateFactory;

public class ProductDAO {
    private static ProductDAO productDAO;
    private final SessionFactory sessionFactory = HibernateFactory.getSessionFactory();

    public static ProductDAO instance() {
        if (productDAO == null) {
            productDAO = new ProductDAO();
        }
        return productDAO;
    }

    private ProductDAO() {
    }

    public List<Product> getAll() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Product.class);
        return (List<Product>) criteria.list();
    }

    public void add(Product product) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();
        session.close();

    }
}
