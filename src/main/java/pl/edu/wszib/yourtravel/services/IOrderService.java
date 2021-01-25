package pl.edu.wszib.yourtravel.services;

import pl.edu.wszib.yourtravel.model.Order;

public interface IOrderService {
    void saveOrder(Order order);
    Order getOrderById(int id);
}
