package pl.edu.wszib.yourtravel.dao.impl;

import pl.edu.wszib.yourtravel.dao.IOrderDAO;
import pl.edu.wszib.yourtravel.model.Order;
import pl.edu.wszib.yourtravel.model.User;

import java.util.List;

public class OrderDAOStub implements IOrderDAO {
    @Override
    public boolean saveOrder(Order order) {
        return false;
    }

    @Override
    public Order getOrderById(int id) {
        return null;
    }

    @Override
    public List<Order> getAllOrdersByUser(User user) {
        return null;
    }

    @Override
    public List<Order> getAllOrders() {
        return null;
    }


}
