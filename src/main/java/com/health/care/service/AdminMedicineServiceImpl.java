package com.health.care.service;

import com.health.care.dao.AdminMedicineDao;
import com.health.care.model.Cart;
import com.health.care.model.MedicineData;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminMedicineServiceImpl implements AdminMedicalService {

    @Autowired
    private AdminMedicineDao adminMedicineDao;

    @Override
    public int saveMedicine(MedicineData medicineData)throws InterruptedException {
       return adminMedicineDao.saveMedicine(medicineData);
    }

    @Override
    public Optional<MedicineData> getMedicine(int id) {

        return adminMedicineDao.getMedicine(id);
    }

    @Override
    public List<MedicineData> getAllMedicines() {
        return adminMedicineDao.getAllMedicines();
    }

    @Override
    public String removeMedicine(int id) {

        return adminMedicineDao.removeMedicine(id);
    }

    @Override
    public Optional<MedicineData> updateMedicine(MedicineData medicineData) {
        return adminMedicineDao.updateMedicine(medicineData);
    }

    @Override
    public List<MedicineData> getMedicineByUses(String uses) {
        return adminMedicineDao.getMedicineByUses(uses);
    }

    @Override
    public void addOrders(Cart orders) throws NotFoundException{

        adminMedicineDao.addOrders(orders);
    }

    @Override
    public String removeOrder(int id) {
        return adminMedicineDao.removeOrder(id);
    }

    @Override
    public Optional<Cart> updateCart(Cart cart)throws NotFoundException {
        return adminMedicineDao.updateCart(cart);
    }

    @Override
    public List<Cart> getOrdesr() {
        return adminMedicineDao.getOrdesr();
    }


}
