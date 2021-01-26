package pl.edu.wszib.yourtravel.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.yourtravel.dao.IOrderDAO;
import pl.edu.wszib.yourtravel.dao.IOrderPositionsDAO;
import pl.edu.wszib.yourtravel.dao.ITourDAO;
import pl.edu.wszib.yourtravel.model.Order;
import pl.edu.wszib.yourtravel.model.OrderPositions;
import pl.edu.wszib.yourtravel.model.Tour;
import pl.edu.wszib.yourtravel.model.User;
import pl.edu.wszib.yourtravel.services.IOrderService;
import pl.edu.wszib.yourtravel.session.SessionObject;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    IOrderDAO orderDAO;

    @Autowired
    IOrderPositionsDAO orderPositionsDAO;

    @Autowired
    ITourDAO tourDAO;

    @Resource
    SessionObject sessionObject;

    @Override
    public double calculateTotal() {
        double sum=0;
        for (Tour tour : this.sessionObject.getBasket()){
            sum = sum + tour.getPrice() * tour.getSeats();
        }
        return sum;
    }

    @Override
    public boolean saveOrderPosition(OrderPositions orderPositions) {
        List<Tour> tours = this.sessionObject.getBasket();
        OrderPositions newPosition = new OrderPositions();
        newPosition.setId(0);
        newPosition.setPieces(1);
        newPosition.setTour(tours.get(1));
        newPosition.setOrder(this.orderDAO.getOrderById(1));
        return this.orderPositionsDAO.saveOrderPosition(newPosition);
    }

    @Override
    public boolean saveOrder(Order order) {
        Set<OrderPositions> positions = new HashSet<>();
        positions.add(new OrderPositions());
        Order newOrder = new Order(0, this.sessionObject.getLoggedUser(), positions,  this.calculateTotal(), Order.Status.ORDERED);
        return this.orderDAO.saveOrder(newOrder);
    }

    @Override
    public Order getOrderById(int id) {
        return this.orderDAO.getOrderById(id);
    }

    @Override
    public List<Order> getAllOrdersByUser(User user) {
        return this.orderDAO.getAllOrdersByUser(user);
    }
}
