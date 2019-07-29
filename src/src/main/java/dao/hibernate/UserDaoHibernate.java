package dao.hibernate;

import dao.UsersDAO;
import model.User;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UserDaoHibernate implements UsersDAO {
    private static final Logger logger = Logger.getLogger(UserDaoHibernate.class);

    @Override
    public void add(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            logger.info("User added");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error adding user", e);
        }
    }

    @Override
    public List<User> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM users", User.class).list();
        }
    }

    @Override
    public Optional<User> getUserById(Long userId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            User user = session.load(User.class, userId);
            if (Objects.isNull(user)) {
                return Optional.empty();
            } else {
                return Optional.of(user);
            }
        }
    }

    @Override
    public void removeUser(Long userId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            if (getUserById(userId).isPresent()) {
                session.delete(getUserById(userId).get());
            }
            transaction.commit();
            logger.info("User removed");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error removing user", e);
        }
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            User user = session.byNaturalId(User.class)
                    .using("email", email)
                    .load();
            if (Objects.isNull(user)) {
                return Optional.empty();
            } else {
                return Optional.of(user);
            }
        }
    }

    @Override
    public void updateUser(User newUser, User oldUser) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update("user", newUser);
            transaction.commit();
            logger.info("User updated");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Error updating user", e);
        }
    }
}
