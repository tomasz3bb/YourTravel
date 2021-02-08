package pl.edu.wszib.yourtravel.services.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.edu.wszib.yourtravel.configuration.AppConfiguration;
import pl.edu.wszib.yourtravel.configuration.TestConfiguration;
import pl.edu.wszib.yourtravel.dao.IOrderDAO;
import pl.edu.wszib.yourtravel.dao.IOrderPositionsDAO;
import pl.edu.wszib.yourtravel.dao.ITourDAO;
import pl.edu.wszib.yourtravel.dao.IUserDAO;
import pl.edu.wszib.yourtravel.model.User;
import pl.edu.wszib.yourtravel.model.view.RegistrationModel;
import pl.edu.wszib.yourtravel.services.IUserService;
import pl.edu.wszib.yourtravel.session.SessionObject;

import javax.annotation.Resource;

import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfiguration.class})
@WebAppConfiguration
public class UserServiceImplTest {

    @Autowired
    IUserService userService;

    @MockBean
    ITourDAO tourDAO;

    @MockBean
    IUserDAO userDAO;

    @MockBean
    IOrderDAO orderDAO;

    @MockBean
    IOrderPositionsDAO orderPositionsDAO;

    @Resource
    SessionObject sessionObject;

    @Before
    public void configureMocks(){
        Mockito.when(this.userDAO.getUserByLogin("logintest")).thenReturn(null);
        Mockito.when(this.userDAO.persist(any())).thenReturn(true );
        Mockito.when(this.userDAO.getUserByLogin("login2")).thenReturn(new User());
        Mockito.when(this.userDAO.getUserByLogin("tomek")).thenReturn(generateUser());
        Mockito.when(this.userDAO.getUserByLogin("jan")).thenReturn(null);
        Mockito.when(this.userDAO.getUserByLogin("tomek")).thenReturn(generateUser());
    }

    @Test
    public void registerTest(){
        RegistrationModel registrationModel = new RegistrationModel();
        registrationModel.setLogin("logintest");
        registrationModel.setPass("passtest");
        registrationModel.setPass("passtest");

        boolean result = userService.register(registrationModel);

        Assert.assertTrue(result);
    }

    @Test
    public void registerLoginIncorrectTest(){
        RegistrationModel registrationModel = new RegistrationModel();
        registrationModel.setLogin("login2");
        registrationModel.setPass("pass2");
        registrationModel.setPass("pass2 ");

        boolean result = userService.register(registrationModel);

        Assert.assertFalse(result);
    }

    @Test
    public void correctAuthenticationTest(){
        User user = new User();
        user.setLogin("tomek");
        user.setPass("tomek");

        this.userService.authenticate(user);

        Assert.assertNotNull(this.sessionObject.getLoggedUser());
    }

    @Test
    public void incorrectAuthenticationTest(){
        User user = new User();
        user.setLogin("jan");
        user.setPass("jan");

        this.userService.authenticate(user);

        Assert.assertNull(this.sessionObject.getLoggedUser());
    }

    @Test
    public void incorrectPassTest(){
        User user = new User();
        user.setLogin("tomek");
        user.setPass("tomek123");

        this.userService.authenticate(user);

        Assert.assertNull(this.sessionObject.getLoggedUser());
    }

    private User generateUser(){
        User user = new User();
        user.setId(5);
        user.setLogin("tomek");
        user.setPass("tomek");
        user.setRole(User.Role.USER);

        return user;
    }
}
