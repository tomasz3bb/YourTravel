package pl.edu.wszib.yourtravel.configuration;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.edu.wszib.yourtravel.dao.*;
import pl.edu.wszib.yourtravel.dao.impl.OrderDAOStub;
import pl.edu.wszib.yourtravel.dao.impl.TourDAOStub;
import pl.edu.wszib.yourtravel.dao.impl.UserDAOStub;

@Configuration
@ComponentScan(basePackages = {
        "pl.edu.wszib.yourtravel.controllers",
        "pl.edu.wszib.yourtravel.services.impl",
        "pl.edu.wszib.yourtravel.session"
})
public class TestConfiguration {

/*
    @Bean
    public ITourDAO tourDAO(){
        return Mockito.mock(ITourDAO.class);
    }

    @Bean
    public IOrderDAO orderDAO(){
        return Mockito.mock(IOrderDAO.class);
    }

    @Bean
    public IUserDAO userDAO(){
        return Mockito.mock(IUserDAO.class);
    }

    @Bean
    public IOrderPositionsDAO orderPositionsDAO(){
        return Mockito.mock(IOrderPositionsDAO.class);
    }

 */

}
