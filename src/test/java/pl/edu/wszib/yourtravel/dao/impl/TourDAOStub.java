package pl.edu.wszib.yourtravel.dao.impl;

import pl.edu.wszib.yourtravel.dao.ITourDAO;
import pl.edu.wszib.yourtravel.model.Tour;

import java.util.List;

public class TourDAOStub implements ITourDAO {


    @Override
    public Tour getTourById(int id) {
        return null;
    }

    @Override
    public void updateTour(Tour tour) {

    }

    @Override
    public boolean addTour(Tour tour) {
        return false;
    }

    @Override
    public void deleteTour(Tour tour) {

    }

    @Override
    public List<Tour> getAllTours() {
        return null;
    }
}
