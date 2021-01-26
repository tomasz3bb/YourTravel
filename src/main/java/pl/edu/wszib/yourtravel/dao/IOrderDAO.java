package pl.edu.wszib.yourtravel.dao;

import pl.edu.wszib.yourtravel.model.Order;

import java.util.List;

public interface IOrderDAO {
    boolean saveOrder(Order order);
    Order getOrderById(int id);
    List<Order> getAllOrders();
}
