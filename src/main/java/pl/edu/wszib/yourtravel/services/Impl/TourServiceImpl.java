package pl.edu.wszib.yourtravel.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.yourtravel.dao.ITourDAO;
import pl.edu.wszib.yourtravel.model.Tour;
import pl.edu.wszib.yourtravel.model.view.TourModel;
import pl.edu.wszib.yourtravel.services.ITourService;

import java.util.List;

@Service
public class TourServiceImpl implements ITourService {

    @Autowired
    ITourDAO tourDAO;

    @Override
    public Tour getTourById(int id) {
        return this.tourDAO.getTourById(id);
    }

    @Override
    public List<Tour> getAllTours() {
        return this.tourDAO.getAllTours();
    }

    @Override
    public void updateTour(Tour tour) {
        Tour tourFromDatabase = this.tourDAO.getTourById(tour.getId());
        tourFromDatabase.setTitle(tour.getTitle());
        tourFromDatabase.setCountry(tour.getCountry());
        tourFromDatabase.setStartDate(tour.getStartDate());
        tourFromDatabase.setEndDate(tour.getEndDate());
        tourFromDatabase.setPrice(tour.getPrice());
        tourFromDatabase.setSeats(tour.getSeats());

        this.tourDAO.updateTour(tourFromDatabase);
    }

    @Override
    public boolean addTour(TourModel tourModel) {
        Tour newTour = new Tour(0, tourModel.getTitle(), tourModel.getCountry(), tourModel.getStartDate(),
                tourModel.getEndDate(), tourModel.getPrice(), tourModel.getSeats());
        return this.tourDAO.addTour(newTour);
    }

    @Override
    public void deleteTour(Tour tour) {
        Tour tourFromDatabase = this.tourDAO.getTourById(tour.getId());
        this.tourDAO.deleteTour(tourFromDatabase);
    }
}
