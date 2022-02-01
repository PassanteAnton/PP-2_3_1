package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void saveUser(User user);
    List<User> getAllUsers();
    User getUser(Long id);
    void updateUser( User user);
    void deleteUser(User user);

}
