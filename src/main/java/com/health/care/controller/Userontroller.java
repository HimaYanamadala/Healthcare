package com.health.care.controller;

import com.health.care.model.Cart;
import com.health.care.model.CustomerData;
import com.health.care.model.MedicineData;
import com.health.care.service.AdminMedicalService;
import com.health.care.service.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
class UserController {

    @Autowired
    private AdminMedicalService adminMedicalService;

    @Autowired
    private UserService userService;

    @GetMapping(path="/api/user/{uses}")
    public List<MedicineData> getMedicine(@PathVariable("uses") String uses){

        List<MedicineData> medicineData = adminMedicalService.getMedicineByUses(uses);
        return medicineData;

    }

    @PostMapping(path="/api/user")
    public void addToCart(@RequestBody Cart orders) throws NotFoundException {
        orders.setAmount(orders.getQuantity()*orders.getPrice());
       // Cart orders=new Cart();
        //orders.setMedicine(medicineData1.get());
        adminMedicalService.addOrders(orders);
       // return medicineData;

    }


    @DeleteMapping(path="/api/user/removeOrder/{id}")
    public String deleteOrder(@PathVariable("id") int id){

        String status= adminMedicalService.removeOrder(id);
        return status;

    }

    @PutMapping(path="/api/user/updateCart")
    public Optional<Cart> updateMedicine(@RequestBody Cart cart) throws NotFoundException {

        Optional<Cart> status= adminMedicalService.updateCart(cart);
        return status;

    }

    @PostMapping(path="/api/user/signup")
    public int addUser(@RequestBody CustomerData user) {

        return userService.addUser(user);

    }

    @PutMapping(path="/api/user/updateUser")
    public Optional<CustomerData> updateUser(@RequestBody CustomerData customer) throws NotFoundException {

        Optional<CustomerData> status= userService.updateUser(customer);
        return status;
    }
}
