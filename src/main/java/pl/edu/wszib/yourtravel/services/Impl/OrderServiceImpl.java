package pl.edu.wszib.yourtravel.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.yourtravel.dao.IOrderDAO;
import pl.edu.wszib.yourtravel.model.Order;
import pl.edu.wszib.yourtravel.services.IOrderService;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    IOrderDAO orderDAO;

    @Override
    public void saveOrder(Order order) {
        this.orderDAO.saveOrder(order);
    }

    @Override
    public Order getOrderById(int id) {
        return this.orderDAO.getOrderById(id);
    }
}
