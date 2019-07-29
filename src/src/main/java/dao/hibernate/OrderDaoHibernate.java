package dao.hibernate;

import dao.OrderDetailsDAO;
import model.OrderDetails;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

public class OrderDaoHibernate implements OrderDetailsDAO {
    private static final Logger logger = Logger.getLogger(OrderDaoHibernate.class);

    @Override
    public void addOrder(OrderDetails orderDetails) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(orderDetails);
            transaction.commit();
            logger.info("Order added");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error adding order", e);
        }
    }
}
