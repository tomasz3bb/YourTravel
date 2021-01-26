package pl.edu.wszib.yourtravel.dao;

import pl.edu.wszib.yourtravel.model.OrderPositions;

public interface IOrderPositionsDAO {
    OrderPositions getOrderPositionById(int id);
    boolean saveOrderPosition(OrderPositions orderPositions);
}
