package pl.edu.wszib.yourtravel.services;

import pl.edu.wszib.yourtravel.model.Tour;

import java.util.List;

public interface ITourService {
    Tour getTourById(int id);
    List<Tour> getAllTours();
    void updateTour(Tour tour);
}
