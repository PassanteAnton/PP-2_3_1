package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);
    List<User> getAllUser();
    User getUser(Long id);
    void updateUser( User user);
    void deleteUser(User user);
}
