package com.health.care.controller;

import com.health.care.model.Cart;
import com.health.care.model.MedicineData;
import com.health.care.service.AdminMedicalService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EHealthCareController {

    @Autowired
    private AdminMedicalService adminMedicalService;

    @PostMapping(path="/api/admin/addMedicine")
    public int addMedicine(@RequestBody MedicineData medicineData)throws InterruptedException{

       return adminMedicalService.saveMedicine(medicineData);

    }

    @GetMapping(path="/api/admin/medicine/{id}")
    public Optional<MedicineData> getMedicine(@PathVariable("id") int id){

        Optional<MedicineData> medicineData = adminMedicalService.getMedicine(id);
        return medicineData;

    }
    @GetMapping(path="/api/admin/allMedicines")
    public List<MedicineData> getAllMedicine(){

        List<MedicineData> medicineData = adminMedicalService.getAllMedicines();
        return medicineData;

    }

    @GetMapping(path="/api/admin/orders")
    public List<Cart> getCart(){

        List<Cart> medicineData = adminMedicalService.getOrdesr();
        return medicineData;

    }

    @DeleteMapping(path="/api/admin/removeMedicine/{id}")
    public String deleteMedicine(@PathVariable("id") int id){

        String status= adminMedicalService.removeMedicine(id);
        return status;

    }

    @PutMapping(path="/api/admin/updateMedicine")
    public Optional<MedicineData> updateMedicine(@RequestBody MedicineData medicineData) throws NotFoundException {

        Optional<MedicineData> medicineData1 = adminMedicalService.getMedicine(medicineData.getId());
        if(!medicineData1.isPresent()){
            throw new NotFoundException("Not found medicine : "+medicineData.getId());
        }
        Optional<MedicineData> status= adminMedicalService.updateMedicine(medicineData);
        return status;

    }
}
