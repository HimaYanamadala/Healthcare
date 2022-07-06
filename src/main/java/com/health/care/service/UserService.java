package com.health.care.service;

import com.health.care.model.Cart;
import com.health.care.model.CustomerData;
import javassist.NotFoundException;

import java.util.Optional;

public interface UserService {
    int addUser(CustomerData user);

    Optional<CustomerData> updateUser(CustomerData customer) throws NotFoundException;
}
