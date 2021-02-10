package pl.edu.wszib.yourtravel.model;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Date;

public class TourTest {

    @Test
    public void TourCloneTest(){

        Tour tour = new Tour();
        tour.setId(1);
        tour.setTitle("Szlakiem faraonów");
        tour.setCountry("Egipt");
        tour.setStartDate(Date.valueOf("2021-01-12"));
        tour.setEndDate(Date.valueOf("2021-01-24"));
        tour.setSeats(50);
        tour.setPrice(765.50);

        Tour clone = tour.clone();

        Assert.assertEquals(tour.getId(), clone.getId());
        Assert.assertEquals(tour.getTitle(), clone.getTitle());
        Assert.assertEquals(tour.getCountry(), clone.getCountry());
        Assert.assertEquals(tour.getStartDate(), clone.getStartDate());
        Assert.assertEquals(tour.getEndDate(), clone.getEndDate());
        Assert.assertEquals(tour.getSeats(), clone.getSeats());
        Assert.assertEquals(tour.getPrice(), clone.getPrice(), 0.001);

        Assert.assertNotSame(tour, clone);

    }
}
