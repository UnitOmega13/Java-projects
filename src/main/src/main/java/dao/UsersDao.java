package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import utils.HibernateFactory;
import Entiny.User;

import java.util.NoSuchElementException;

public class UsersDao {
    private static UsersDao userDAO;
    private final SessionFactory sessionFactory = HibernateFactory.getSessionFactory();

    public static UsersDao instance() {
        if (userDAO == null) {
            userDAO = new UsersDao();
        }
        return userDAO;
    }

    private UsersDao() {
    }

    public boolean addUser(String login, String password) {
        if ((login == null) || (password == null) || (login.equals("")) || (password.equals(""))) {
            return false;
        }
        if(getUserByLogin(login)==null) {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(new User(login, password));
            session.getTransaction().commit();
            session.close();
            return true;
        }
        return false;
    }

    public User getUserByLogin(String login) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM User WHERE login='" + login + "'");
        try {
            User u = (User) query.iterate().next();
            User user = new User(u.getLogin(),u.getPassword());
            session.close();
            return user;
        }catch (NoSuchElementException ex) {
            return null;
        }

    }
}
