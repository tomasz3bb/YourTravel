package pl.edu.wszib.yourtravel.dao.Impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.yourtravel.dao.IOrderDAO;
import pl.edu.wszib.yourtravel.model.Order;

@Repository
public class OrderDAOImpl implements IOrderDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void saveOrder(Order order) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx=session.beginTransaction();
            session.save(order);
            tx.commit();
        } catch (Exception e) {
            if (tx != null){
                tx.rollback();
            }
        }
        finally {
            session.close();
        }
    }



    @Override
    public Order getOrderById(int id) {
        Session session = this.sessionFactory.openSession();
        Query<Order> query = session.createQuery("FROM pl.edu.wszib.yourtravel.model.Order where id = : id");
        query.setParameter("id", id);
        Order order = query.getSingleResult();
        session.close();
        return order;
    }
}
