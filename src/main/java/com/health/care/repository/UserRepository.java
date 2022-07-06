package com.health.care.repository;

import com.health.care.model.Cart;
import com.health.care.model.MedicineData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Cart,Integer> {
   // void deleteBymedicineName(String medicineName);

    //Optional<Cart> findBymedicineName(String medicineName);

    Optional<Cart> findByMedicineName(String medicineName);

    //void deleteByMedicineName(String medicineName);
}
