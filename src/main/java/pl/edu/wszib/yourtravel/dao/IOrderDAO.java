package pl.edu.wszib.yourtravel.dao;

import pl.edu.wszib.yourtravel.model.Order;

public interface IOrderDAO {
    void saveOrder(Order order);
    Order getOrderById(int id);
}
