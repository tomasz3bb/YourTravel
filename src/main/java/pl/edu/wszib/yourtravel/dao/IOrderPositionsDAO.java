package pl.edu.wszib.yourtravel.dao;

import pl.edu.wszib.yourtravel.model.OrderPositions;

public interface IOrderPositionsDAO {
    boolean saveOrderPosition(OrderPositions orderPositions);
}
