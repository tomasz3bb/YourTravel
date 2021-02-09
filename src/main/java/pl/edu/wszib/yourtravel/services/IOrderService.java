package pl.edu.wszib.yourtravel.services;

import pl.edu.wszib.yourtravel.model.Order;
import pl.edu.wszib.yourtravel.model.OrderPositions;
import pl.edu.wszib.yourtravel.model.User;

import java.util.List;

public interface IOrderService {
    double calculateTotal();
    boolean saveOrder(Order order, OrderPositions orderPositions);
    List<Order> getAllOrdersByUser(User user);
    List<Order> getAllOrders();
    void updateOrder(Order order);
    Order getOrderById(int id);
}
