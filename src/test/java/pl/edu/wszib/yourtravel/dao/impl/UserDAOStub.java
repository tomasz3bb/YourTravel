package pl.edu.wszib.yourtravel.dao.impl;

import pl.edu.wszib.yourtravel.dao.IUserDAO;
import pl.edu.wszib.yourtravel.model.User;

public class UserDAOStub implements IUserDAO {
    @Override
    public User getUserByLogin(String login) {
        if (login.equals("login2")){
            return new User();
        }
        return null;
    }

    @Override
    public boolean persist(User user) {
        return true;
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public boolean updateUser(User currentUser) {

        return false;
    }
}
