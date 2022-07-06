package com.health.care.service;

import com.health.care.model.Cart;
import com.health.care.model.MedicineData;
import javassist.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface AdminMedicalService {

    public int saveMedicine(MedicineData medicineData)throws InterruptedException;
    public Optional<MedicineData> getMedicine(int id);
    public List<MedicineData> getAllMedicines();
    public String removeMedicine(int id);
    public Optional<MedicineData> updateMedicine(MedicineData medicineData);

   public List<MedicineData> getMedicineByUses(String uses);

   public void addOrders(Cart orders) throws NotFoundException;

   public String removeOrder(int id);

   public  Optional<Cart> updateCart(Cart cart)throws NotFoundException;

    List<Cart> getOrdesr();
}
