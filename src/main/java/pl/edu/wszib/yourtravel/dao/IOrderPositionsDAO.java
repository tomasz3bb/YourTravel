package pl.edu.wszib.yourtravel.dao;

import pl.edu.wszib.yourtravel.model.OrderPositions;

import java.util.List;

public interface IOrderPositionsDAO {
    boolean saveOrderPosition(OrderPositions orderPositions);
}
