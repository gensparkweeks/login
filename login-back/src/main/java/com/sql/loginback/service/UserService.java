package com.sql.loginback.service;
import com.sql.loginback.model.User;
import java.util.List;

public interface UserService {

    List<User> findAll();
    User findById(int id);
    User createUser(User user);
    User updateUser(User user);
    void deleteUser(int id);
}
