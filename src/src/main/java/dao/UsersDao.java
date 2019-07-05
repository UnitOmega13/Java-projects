package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import service.DataBaseService;
import utils.HibernateFactory;
import Entiny.User;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class UsersDao implements InterfaceDAO{
    private static UsersDao userDAO;
    private final SessionFactory sessionFactory = HibernateFactory.getSessionFactory();

    public static UsersDao instance() {
        if (userDAO == null) {
            userDAO = new UsersDao();
        }
        return userDAO;
    }

    public UsersDao() {
    }

    public static User create(String email, String login, String password) {
        if (Objects.isNull(email)
                || Objects.isNull(login)
                || Objects.isNull(password)) {
            throw new NoSuchElementException("Wrong arguments!");
        }
        return new User(email, login, password);
    }

    public User getUserByLogin(String login) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM User WHERE login='" + login + "'");
        try {
            User users = (User) query.iterate().next();
            User user = new User(users.getLogin(),users.getEmail() ,users.getPassword());
            session.close();
            return user;
        }catch (NoSuchElementException ex) {
            return null;
        }
    }

    @Override
    public void add(Object item) {
        DataBaseService.users.add(item);
    }

    @Override
    public List getAll() {
        return DataBaseService.users;
    }
}
