package pl.edu.wszib.yourtravel.dao.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.yourtravel.dao.ITourDAO;
import pl.edu.wszib.yourtravel.model.Tour;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TourDAOImpl implements ITourDAO {

    @Autowired
    Connection connection;

    @Override
    public Tour getTourById(int id) {
        String sql = "SELECT * FROM tour WHERE id =?";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                return new Tour(resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("country"),
                        resultSet.getDate("startDate"),
                        resultSet.getDate("endDate"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("seats"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateTour(Tour tour) {
        String sql = "UPDATE tour SET title=?, country=?, startDate=?, endDate=?, price=?, seats=? WHERE id=?";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, tour.getTitle());
            preparedStatement.setString(2, tour.getCountry());
            preparedStatement.setDate(3, tour.getStartDate());
            preparedStatement.setDate(4, tour.getEndDate());
            preparedStatement.setDouble(5, tour.getPrice());
            preparedStatement.setInt(6, tour.getSeats());
            preparedStatement.setInt(7, tour.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean addTour(Tour tour) {
        String sql = "INSERT INTO tour (id, title, country, startDate, endDate, price, seats) VALUES (?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setInt(1, tour.getId());
            preparedStatement.setString(2, tour.getTitle());
            preparedStatement.setString(3, tour.getCountry());
            preparedStatement.setDate(4, tour.getStartDate());
            preparedStatement.setDate(5, tour.getEndDate());
            preparedStatement.setDouble(6, tour.getPrice());
            preparedStatement.setInt(7, tour.getSeats());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Tour> getAllTours() {
        List<Tour> tours = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tour";
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                tours.add(new Tour(resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("country"),
                        resultSet.getDate("startDate"),
                        resultSet.getDate("endDate"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("seats")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return tours;
    }
}
