package java.dbService.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.dbService.dataSets.UsersDataSet;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class UsersDAO {

    private Session session;

    public UsersDAO(Session session) {
        this.session = session;
    }

    public UsersDataSet get(long id) throws HibernateException {
        return session.get(UsersDataSet.class, id);
    }

    public long getUserId(String name) throws HibernateException {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<UsersDataSet> criteria = criteriaBuilder.createQuery(UsersDataSet.class);
        Root<UsersDataSet> usersDataSetRoot = criteria.from(UsersDataSet.class);
        return ((UsersDataSet)criteria.where(criteriaBuilder.equal(usersDataSetRoot.get("name"), name))).getId();
    }

    public long insertUser(String name) throws HibernateException {
        return (Long) session.save(new UsersDataSet(name));
    }
}
