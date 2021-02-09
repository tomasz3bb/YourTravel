package pl.edu.wszib.yourtravel.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.yourtravel.dao.IOrderPositionsDAO;
import pl.edu.wszib.yourtravel.model.OrderPositions;

import java.util.List;

@Repository
public class HibernateOrderPositionsDAOImpl implements IOrderPositionsDAO {

    @Autowired
    SessionFactory sessionFactory;


    @Override
    public boolean saveOrderPosition(OrderPositions orderPositions) {
        Session session=this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx.begin();
            session.saveOrUpdate(orderPositions);
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
