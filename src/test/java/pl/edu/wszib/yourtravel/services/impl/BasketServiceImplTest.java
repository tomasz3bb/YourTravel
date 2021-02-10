package pl.edu.wszib.yourtravel.services.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.edu.wszib.yourtravel.App;
import pl.edu.wszib.yourtravel.configuration.AppConfiguration;
import pl.edu.wszib.yourtravel.configuration.TestConfiguration;
import pl.edu.wszib.yourtravel.dao.IOrderDAO;
import pl.edu.wszib.yourtravel.dao.IOrderPositionsDAO;
import pl.edu.wszib.yourtravel.dao.ITourDAO;
import pl.edu.wszib.yourtravel.dao.IUserDAO;
import pl.edu.wszib.yourtravel.model.Tour;
import pl.edu.wszib.yourtravel.services.IBasketService;
import pl.edu.wszib.yourtravel.session.SessionObject;

import javax.annotation.Resource;
import java.sql.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfiguration.class})
@WebAppConfiguration
public class BasketServiceImplTest {

    @MockBean
    IUserDAO userDAO;

    @MockBean
    ITourDAO tourDAO;

    @MockBean
    IOrderDAO orderDAO;

    @MockBean
    IOrderPositionsDAO orderPositionsDAO;

    @Autowired
    IBasketService basketService;

    @Resource
    SessionObject sessionObject;

    @Test
    public void calculateTotalTest(){
        Date startDate = Date.valueOf("2021-01-12");
        Date endDate = Date.valueOf("2021-01-24");
        sessionObject.getBasket().add(new Tour(1, "Szlakiem faraonów", "Egipt", startDate, endDate , 100.00, 3));
        sessionObject.getBasket().add(new Tour(2,"Stany Ameryki", "USA", startDate, endDate, 200.00, 2 ));

        double expectedResult = 700.0 ;

        double result = this.basketService.calculateTotal();

        Assert.assertEquals(expectedResult, result, 0.01);
    }



}
