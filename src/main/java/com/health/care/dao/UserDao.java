package com.health.care.dao;

import com.health.care.model.Cart;
import com.health.care.model.CustomerData;
import javassist.NotFoundException;

import java.util.Optional;

public interface UserDao {
    int saveUser(CustomerData user);

    Optional<CustomerData> updateUser(CustomerData customer) throws NotFoundException;
}
