package pl.edu.wszib.yourtravel.services;

import pl.edu.wszib.yourtravel.model.User;
import pl.edu.wszib.yourtravel.model.view.PassModel;
import pl.edu.wszib.yourtravel.model.view.RegistrationModel;

public interface IUserService {
    void authenticate(User user);
    void logout();
    boolean register(RegistrationModel registrationModel);
    User getUserById(int id);
    boolean updateUserPass(User user, PassModel passModel);
}
