package pl.edu.wszib.yourtravel.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.yourtravel.dao.ITourDAO;
import pl.edu.wszib.yourtravel.model.Tour;
import pl.edu.wszib.yourtravel.services.IBasketService;
import pl.edu.wszib.yourtravel.session.SessionObject;

import javax.annotation.Resource;

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
        updateSeats(tour);
        for (Tour tourFromBasket : this.sessionObject.getBasket()){
            if (tourFromBasket.getId() == tour.getId()){
                if (tour.getSeats()>0){
                    tourFromBasket.setSeats(tourFromBasket.getSeats()+1);
                    return;
                }else {
                    return;
                }
            }
        }

        tour.setSeats(1);
        this.sessionObject.getBasket().add(tour);
    }
    public void updateSeats (Tour tour){
        tour.setSeats(tour.getSeats()-1);
        this.tourDAO.updateTour(tour);
    }
}
