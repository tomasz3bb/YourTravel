package pl.edu.wszib.yourtravel.dao.Impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.yourtravel.dao.IOrderPositionsDAO;
import pl.edu.wszib.yourtravel.model.OrderPositions;

@Repository
public class HibernateOrderPositionsDAOImpl implements IOrderPositionsDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public OrderPositions getOrderPositionById(int id) {
        Session session = this.sessionFactory.openSession();
        Query<OrderPositions> query = session.createQuery("FROM pl.edu.wszib.yourtravel.model.OrderPositions where id = : id");
        query.setParameter("id", id);
        OrderPositions orderPositions = query.getSingleResult();
        session.close();
        return orderPositions;
    }

    @Override
    public boolean saveOrderPosition(OrderPositions orderPositions) {
        Session session=this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx.begin();
            session.save(orderPositions);
            tx.commit();
        } catch (Exception e) {
            if (tx != null){
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return true;
    }
}
