package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User findUserByCar(int series, String model) {
        Query query = sessionFactory.getCurrentSession().createQuery("from User where Car.series = :series and Car.model = :model");
        return (User) query.setParameter("series", series).setParameter("model", model).uniqueResult();
    }

}

/*
String hql = "FROM User WHERE name = :paramName";
Query query = session.createQuery(hql);
query.setParameter("paramName", "Alex");

// Получаем единственный результат
User user = (User) query.uniqueResult();
 */
