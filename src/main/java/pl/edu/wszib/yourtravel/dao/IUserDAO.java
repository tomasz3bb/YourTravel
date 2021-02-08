package pl.edu.wszib.yourtravel.dao;

import pl.edu.wszib.yourtravel.model.User;

public interface IUserDAO {
    User getUserByLogin(String login);
    boolean persist(User user);
    User getUserById(int id);
    boolean updateUser(User currentUser);
}
