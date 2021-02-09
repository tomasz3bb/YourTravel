package pl.edu.wszib.yourtravel.dao;

import pl.edu.wszib.yourtravel.model.Order;
import pl.edu.wszib.yourtravel.model.User;

import java.util.List;

public interface IOrderDAO {
    boolean saveOrder(Order order);
    boolean updateOrder(Order order);
    Order getOrderById(int id);
    List<Order> getAllOrdersByUser(User user);
    List<Order> getAllOrders();
}
