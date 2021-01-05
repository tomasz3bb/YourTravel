package pl.edu.wszib.yourtravel.services;

public interface IBasketService {
    double calculateTotal();
    void addTourByIdToBasket(int id);
}
