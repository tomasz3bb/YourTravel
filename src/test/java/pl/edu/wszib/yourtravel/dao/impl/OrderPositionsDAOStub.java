package pl.edu.wszib.yourtravel.dao.impl;

import pl.edu.wszib.yourtravel.dao.IOrderPositionsDAO;
import pl.edu.wszib.yourtravel.model.OrderPositions;

import java.util.List;

public class OrderPositionsDAOStub implements IOrderPositionsDAO {

    @Override
    public boolean saveOrderPosition(OrderPositions orderPositions) {
        return false;
    }

}
