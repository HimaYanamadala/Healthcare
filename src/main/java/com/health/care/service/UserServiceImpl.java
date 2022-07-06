package com.health.care.service;

import com.health.care.dao.UserDao;
import com.health.care.model.Cart;
import com.health.care.model.CustomerData;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int addUser(CustomerData user) {
      return  userDao.saveUser(user);
    }

    @Override
    public Optional<CustomerData> updateUser(CustomerData customer) throws NotFoundException {
        return userDao.updateUser(customer);
    }
}
