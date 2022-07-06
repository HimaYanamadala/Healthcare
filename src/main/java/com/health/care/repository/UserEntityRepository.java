package com.health.care.repository;

import com.health.care.model.CustomerData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<CustomerData,Integer> {
}
