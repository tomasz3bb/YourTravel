package pl.edu.wszib.yourtravel.services;

import pl.edu.wszib.yourtravel.model.Order;

import java.util.List;

public interface IOrderService {
    boolean saveOrder(Order order);
    Order getOrderById(int id);
    List<Order> getAllOrders();
}
