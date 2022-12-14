package com.sql.loginback.service;
import com.sql.loginback.dao.UserDao;
import com.sql.loginback.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findById(int id) {
        return userDao.findById(id).orElseThrow();
    }

    @Override
    public User createUser(User user) {
        if (user.getPassword() != null){
            user.setPassword(encoder.encode(user.getPassword()));
        }
        return userDao.save(user);
    }

    @Override
    public User updateUser(User user) {
        if (user.getPassword() != null){
            user.setPassword(encoder.encode(user.getPassword()));
        }
        return userDao.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteById(id);
    }
}
