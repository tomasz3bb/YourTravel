package pl.edu.wszib.yourtravel.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.yourtravel.dao.ITourDAO;
import pl.edu.wszib.yourtravel.model.Tour;
import pl.edu.wszib.yourtravel.services.IBasketService;
import pl.edu.wszib.yourtravel.session.SessionObject;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class BasketServiceImpl implements IBasketService {

    @Autowired
    ITourDAO tourDAO;

    @Resource
    SessionObject sessionObject;

    @Override
    public double calculateTotal() {
        double sum=0;
        for (Tour tour : this.sessionObject.getBasket()){
            sum = sum + tour.getPrice() * tour.getSeats();
        }
        return sum;
    }

    @Override
    public void addTourByIdToBasket(int id) {
        Tour tour = this.tourDAO.getTourById(id);
        if (tour.getSeats() > 0) {
            deleteSeats(tour);
        }else {
            return;
        }
        for (Tour tourFromBasket : this.sessionObject.getBasket()) {
            if (tourFromBasket.getId() == tour.getId()) {
                if (tour.getSeats() >= 0) {
                    tourFromBasket.setSeats(tourFromBasket.getSeats() + 1);
                    return;
                } else {
                    return;
                }
            }
        }
        tour.setSeats(1);
        this.sessionObject.getBasket().add(tour);
    }

    @Override
    public void deleteTourFromBasket(int id) {
        Tour tour = this.tourDAO.getTourById(id);

        for (Tour tourFromBasket : this.sessionObject.getBasket()){
            if (tour.getId() == tourFromBasket.getId()){
                if (tourFromBasket.getSeats() > 0){
                    tourFromBasket.setSeats(tourFromBasket.getSeats() - 1);
                    addSeats(tour);
                    return;
                }else
                    this.sessionObject.getBasket().remove(tourFromBasket);
                    return;
            }
        }
        this.sessionObject.getBasket().remove(tour);
    }


    private void deleteSeats (Tour tour) {
        tour.setSeats(tour.getSeats() - 1);
        this.tourDAO.updateTour(tour);
    }
    private void addSeats (Tour tour) {
        tour.setSeats(tour.getSeats() + 1);
        this.tourDAO.updateTour(tour);
    }
}
