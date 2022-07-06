package com.health.care.repository;

import com.health.care.model.MedicineData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


public interface MedicineRepository extends JpaRepository<MedicineData, Integer> {
    List<MedicineData> findByUses(String uses);

    Optional<MedicineData> findByMedicineName(String medicineName);

  /*  @Transactional
    @Modifying
    @Query("update MEDICINE_DATA c set c.price = ?1 where c.id = ?2")
    int updateById(int price, int id);*/


}
