package com.health.care.dao;

import com.health.care.model.CustomerData;
import com.health.care.repository.UserEntityRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao{

  @Autowired
  private UserEntityRepository userEntityRepository;

    @Override
    public int saveUser(CustomerData user) {
        CustomerData u= userEntityRepository.save(user);
       return u.getId();
    }

    @Override
    public Optional<CustomerData> updateUser(CustomerData customer) throws NotFoundException {

        if(String.valueOf(customer.getId()).equals("0")){
            throw new NotFoundException("Need to pass customer ID to update cart : "+customer.getId());
        }
        Optional<CustomerData> customerData= userEntityRepository.findById(customer.getId());

        if(!customerData.isPresent()){
            throw new NotFoundException("Not found Customer to Update : ");
        }

        CustomerData update= new CustomerData();
        update.setId(customer.getId());
        if(null == customer.getFirstName()){
            update.setFirstName(customerData.get().getFirstName());
        }else{
            update.setFirstName(customer.getFirstName());
        }
        if(null == customer.getLastName()){
            update.setLastName(customerData.get().getLastName());
        }else{
            update.setLastName(customer.getLastName());
        }
        if(null == customer.getEmail()){
            update.setEmail(customerData.get().getEmail());
        }else{
            update.setEmail(customer.getEmail());
        }
        if(null == customer.getPassword()){
            update.setPassword(customerData.get().getPassword());
        }else{
            update.setPassword(customer.getPassword());
        }
        if(null == customer.getPhoneNumber()){
            update.setPhoneNumber(customerData.get().getPhoneNumber());
        }else{
            update.setPhoneNumber(customer.getPhoneNumber());
        }
        if(null == customer.getAddress()){
            update.setAddress(customerData.get().getAddress());
        }else{
            update.setAddress(customer.getAddress());
        }
        if(null == customer.getDiscount()){
            update.setDiscount(customerData.get().getDiscount());
        }else{
            update.setDiscount(customer.getDiscount());
        }
        if(null == customer.getDob()){
            update.setDob(customerData.get().getDob());
        }else{
            update.setDob(customer.getDob());
        }

        userEntityRepository.save(update);
        Optional<CustomerData> updateData= userEntityRepository.findById(customer.getId());
        return updateData;
    }


}
