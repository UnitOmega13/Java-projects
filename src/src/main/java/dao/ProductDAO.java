package dao;

import java.util.List;

import Entiny.Product;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import service.DataBaseService;
import utils.HibernateFactory;

public class ProductDAO implements InterfaceDAO{
    private static ProductDAO productDAO;
    private final SessionFactory sessionFactory = HibernateFactory.getSessionFactory();

    public static ProductDAO instance() {
        if (productDAO == null) {
            productDAO = new ProductDAO();
        }
        return productDAO;
    }

    public ProductDAO() {
    }

    @Override
    public void add(Object item) {
        DataBaseService.products.add(item);
    }

    public List<Product> getAll() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Product.class);
        return (List<Product>) criteria.list();
    }
}
