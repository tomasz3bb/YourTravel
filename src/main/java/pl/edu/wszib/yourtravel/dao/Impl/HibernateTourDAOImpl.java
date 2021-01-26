package pl.edu.wszib.yourtravel.dao.Impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.yourtravel.dao.ITourDAO;
import pl.edu.wszib.yourtravel.model.Tour;

import java.util.List;

@Repository
public class HibernateTourDAOImpl implements ITourDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Tour getTourById(int id) {
        Session session = this.sessionFactory.openSession();
        Query<Tour> query = session.createQuery("FROM pl.edu.wszib.yourtravel.model.Tour WHERE id = :id");
        query.setParameter("id", id);
        Tour tour = null;
        try {
            tour = query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return tour;
    }

    @Override
    public void updateTour(Tour tour) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(tour);
            tx.commit();
        } catch (Exception e) {
            if (tx != null){
                tx.rollback();
            }
        }finally {
            session.close();
        }
    }

    @Override
    public boolean addTour(Tour tour) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(tour);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        }finally {
            session.close();
        }
        return true;
    }

    @Override
    public void deleteTour(Tour tour) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(tour);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        }finally {
            session.close();
        }
    }

    @Override
    public List<Tour> getAllTours() {
        Session session = this.sessionFactory.openSession();
        Query<Tour> query = session.createQuery( "FROM pl.edu.wszib.yourtravel.model.Tour");
        List<Tour> tours = query.getResultList();
        session.close();
        return tours;
    }
}
