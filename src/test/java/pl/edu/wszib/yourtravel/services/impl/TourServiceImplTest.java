package pl.edu.wszib.yourtravel.services.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.edu.wszib.yourtravel.configuration.TestConfiguration;
import pl.edu.wszib.yourtravel.dao.IOrderDAO;
import pl.edu.wszib.yourtravel.dao.IOrderPositionsDAO;
import pl.edu.wszib.yourtravel.dao.ITourDAO;
import pl.edu.wszib.yourtravel.dao.IUserDAO;
import pl.edu.wszib.yourtravel.model.Tour;
import pl.edu.wszib.yourtravel.services.ITourService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfiguration.class})
@WebAppConfiguration
public class TourServiceImplTest {


    @MockBean
    ITourDAO tourDAO;

    @MockBean
    IUserDAO userDAO;

    @MockBean
    IOrderDAO orderDAO;

    @MockBean
    IOrderPositionsDAO orderPositionsDAO;

    @Autowired
    ITourService tourService;

    @Test
    public void addTourTest(){
        Tour tour = new Tour();
        tour.setId(10);
        tour.setTitle("Warszawa");
        tour.setCountry("Polska");
        tour.setStartDate(Date.valueOf("2021-10-20"));
        tour.setEndDate(Date.valueOf("2021-11-10"));
        tour.setSeats(10);
        tour.setPrice(500);

        Mockito.when(this.tourDAO.addTour(tour)).thenReturn(true);

        boolean result = this.tourService.addTour(tour);

        Assert.assertNotNull(result);

    }

    @Test
    public void getTourByIdTest() {
        Tour tour = new Tour();
        tour.setId(10);

        Mockito.when(this.tourDAO.getTourById(10)).thenReturn(tour);

        this.tourService.getTourById(10);

        Assert.assertNotNull(this.tourService.getTourById(10));
    }

    @Test
    public void getAllToursTest(){
        List<Tour> tours = new ArrayList<>();

        Mockito.when(this.tourDAO.getAllTours()).thenReturn(tours);

        this.tourService.getAllTours();

        Assert.assertNotNull(tours);
    }
}
