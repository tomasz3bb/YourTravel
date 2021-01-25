package pl.edu.wszib.yourtravel.dao.Impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.yourtravel.dao.IUserDAO;
import pl.edu.wszib.yourtravel.model.User;

import javax.persistence.NoResultException;

@Repository
public class HibernateUserDAOImpl implements IUserDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public User getUserByLogin(String login) {
        Session session = this.sessionFactory.openSession();
        Query<User> query = session.createQuery("FROM pl.edu.wszib.yourtravel.model.User WHERE login = :login");
        query.setParameter("login", login);
        User result = null;
        try {
            result = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.printf("Nie znaleziono usera! ");
        }
        session.close();
        return result;
    }

    @Override
    public boolean persist(User user) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(user);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null){
                tx.rollback();
            }
        }
        finally {
            session.close();
        }
        return false;
    }

}
