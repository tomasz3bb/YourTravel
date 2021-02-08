package pl.edu.wszib.yourtravel.services;

import pl.edu.wszib.yourtravel.model.Tour;

public interface IBasketService {
    double calculateTotal();
    void addTourByIdToBasket(int id);
    void deleteTourFromBasket(int id);
}
