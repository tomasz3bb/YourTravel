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
import java.util.List;


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
    public List<Order> getAllOrdersByUser(User user) {
        return this.orderDAO.getAllOrdersByUser(user);
    }


    @Override
    public boolean saveOrder(Order order, OrderPositions orderPositions){
        List<Tour> tours = this.sessionObject.getBasket();

        OrderPositions positions = new OrderPositions();
        Order newOrder = new Order();
        newOrder.setUser(this.sessionObject.getLoggedUser());
        newOrder.setStatus(Order.Status.ORDERED);
        newOrder.setPrice(calculateTotal());

        for (int i=0; i<tours.size(); i++){
            OrderPositions newPosition = new OrderPositions();
            newPosition.setTour(tours.get(i));
            newPosition.setOrder(newOrder);
            newOrder.getPositions().add(newPosition);
            newPosition.setPieces(tours.get(i).getSeats());
            positions = newPosition;
        }

        return this.orderPositionsDAO.saveOrderPosition(positions) && this.orderDAO.saveOrder(newOrder);
    }
}
