package pl.edu.wszib.yourtravel.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.yourtravel.dao.IOrderDAO;
import pl.edu.wszib.yourtravel.model.Order;
import pl.edu.wszib.yourtravel.services.IOrderService;

import java.util.List;


@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    IOrderDAO orderDAO;

    @Override
    public boolean saveOrder(Order order) {
        Order newOrder = new Order();
        return this.orderDAO.saveOrder(newOrder);
    }

    @Override
    public Order getOrderById(int id) {
        return this.orderDAO.getOrderById(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return this.orderDAO.getAllOrders();
    }
}
