package pl.edu.wszib.yourtravel.services;

import pl.edu.wszib.yourtravel.model.User;
import pl.edu.wszib.yourtravel.model.view.RegistrationModel;

public interface IUserService {
    void authenticate(User user);
    void logout();
    boolean register(RegistrationModel registrationModel);
    boolean changePass(String login, String pass);
}
