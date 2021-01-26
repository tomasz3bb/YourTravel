package pl.edu.wszib.yourtravel.dao;

import pl.edu.wszib.yourtravel.model.Tour;

import java.util.List;

public interface ITourDAO {
    Tour getTourById(int id);
    void updateTour(Tour tour);
    boolean addTour(Tour tour);
    void deleteTour(Tour tour);
    List<Tour> getAllTours();
}

