package pl.edu.wszib.yourtravel.rest.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wszib.yourtravel.model.Tour;
import pl.edu.wszib.yourtravel.model.User;

import java.sql.Date;

@RequestMapping(value = "/api")
@RestController
public class SimpleRestController {

    @RequestMapping(value = "/endpoint1", method = RequestMethod.GET)
    public User getUser(){
        User user = new User();
        user.setId(1);
        user.setLogin("admin");
        user.setPass("admin");
        user.setRole(User.Role.ADMIN);
        return user;
    }

    @RequestMapping(value = "/endpoint2", method = RequestMethod.GET)
    public Tour getTour1(){
        Tour tour1 = new Tour();
        tour1.setId(1);
        tour1.setTitle("Szlakiem faraonów");
        tour1.setCountry("Egipt");
        tour1.setStartDate(Date.valueOf("2021-01-12"));
        tour1.setEndDate(Date.valueOf("2021-01-24"));
        tour1.setSeats(50);
        tour1.setPrice(765.50);

        return tour1 ;
    }

    @RequestMapping(value = "/endpoint3", method = RequestMethod.GET)
    public Tour getTour2(){
        Tour tour2 = new Tour();
        tour2.setId(2);
        tour2.setTitle("Alpy");
        tour2.setCountry("Austria");
        tour2.setStartDate(Date.valueOf("2021-02-08"));
        tour2.setEndDate(Date.valueOf("2021-02-23"));
        tour2.setSeats(20);
        tour2.setPrice(365.50);

        return tour2 ;
    }

}
