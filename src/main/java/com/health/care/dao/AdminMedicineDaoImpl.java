package com.health.care.dao;

import com.health.care.model.Cart;
import com.health.care.model.MedicineData;
import com.health.care.repository.MedicineRepository;
import com.health.care.repository.UserRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class AdminMedicineDaoImpl implements AdminMedicineDao{

    @Autowired
    private MedicineRepository medicineRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public int saveMedicine(MedicineData medicineData) throws InterruptedException {

        Optional<MedicineData> existedData =  medicineRepository.findByMedicineName(medicineData.getMedicineName());
        if(existedData.isPresent()){
            throw new InterruptedException("Medicine is already existed please update the medicine");
        }
        System.out.println(medicineData);
        medicineRepository.save(medicineData);
        System.out.println("saved successfully  : "+medicineData.getId());

        return medicineData.getId();
    }

    @Override
    public Optional<MedicineData> getMedicine(int id) {
        Optional<MedicineData> medicineData= medicineRepository.findById(id);
        return medicineData;
    }

    @Override
    public List<MedicineData> getAllMedicines() {
        List< MedicineData> medicineData= medicineRepository.findAll();
        return medicineData;
    }

    @Override
    public String removeMedicine(int id) {
        medicineRepository.deleteById(id);
        return "record deleted successfully";
    }




    public Optional<MedicineData> updateMedicine1(int id, int price) {
       // medicineRepository.updateById(price,id);
        return getMedicine(id);
       // return "record updated successfully";
    }


    @Override
    public Optional<MedicineData> updateMedicine(MedicineData data) {
        Optional<MedicineData> medicineData= medicineRepository.findById(data.getId());

        MedicineData update= new MedicineData();
        update.setId(data.getId());
        if(null == data.getMedicineName()){
            update.setMedicineName(medicineData.get().getMedicineName());
        }else{
            update.setMedicineName(data.getMedicineName());
        }
        if(null == data.getCompanyName()){
            update.setCompanyName(medicineData.get().getCompanyName());
        }else{
            update.setCompanyName(data.getCompanyName());
        }
        String p= String.valueOf(data.getPrice());
        if(p.equals("0")){
            update.setPrice(medicineData.get().getPrice());
        }else{
            update.setPrice(data.getPrice());
        }
        String q= String.valueOf(data.getQuantity());
        if(q.equals("0")){
            update.setQuantity(medicineData.get().getQuantity());
        }else{
            update.setQuantity(data.getQuantity());
        }
        if(null == data.getUses()){
            update.setUses(medicineData.get().getUses());
        }else{
            update.setUses(data.getUses());
        }

        if(null == data.getDiscount()){
            update.setDiscount(medicineData.get().getDiscount());
        }else{
            update.setDiscount(data.getDiscount());
        }
        if(null == data.getExpireDate()){
            update.setExpireDate(medicineData.get().getExpireDate());
        }else{
            update.setExpireDate(data.getExpireDate());
        }
        medicineRepository.save(update);
        Optional<MedicineData> updatedata= medicineRepository.findById(data.getId());
        return updatedata;
    }

    @Override
    public List<MedicineData> getMedicineByUses(String uses) {
        List<MedicineData> medicineData= medicineRepository.findByUses(uses);
        return medicineData;
    }

    @Override
    public void addOrders(Cart orders) throws NotFoundException{
        Optional<MedicineData> medicineData = medicineRepository.findByMedicineName(orders.getMedicineName());
        if(!medicineData.isPresent()){
            throw new NotFoundException("Out of stock for the medicine : "+orders.getMedicineName());
        }
        userRepository.save(orders);
    }

    @Override
    public String removeOrder(int id){
        userRepository.deleteById(id);
        return "record deleted successfully";
    }

    @Override
    public Optional<Cart> updateCart(Cart cart) throws NotFoundException {

        if(null == cart.getMedicineName()){
            throw new NotFoundException("Need to pass medicineName to update cart : "+cart.getMedicineName());
        }
        Optional<Cart> cartData= userRepository.findByMedicineName(cart.getMedicineName());

        if(!cartData.isPresent()){
            throw new NotFoundException("Not found medicine : "+cart.getMedicineName());
        }
        Cart update= new Cart();
            update.setId(cart.getId());
            update.setMedicineName(cartData.get().getMedicineName());

        String p= String.valueOf(cart.getPrice());
        if(p.equals("0")){
            update.setPrice(cartData.get().getPrice());
        }else{
            update.setPrice(cart.getPrice());
        }
        String q= String.valueOf(cart.getQuantity());
        if(q.equals("0")){
            update.setQuantity(cartData.get().getQuantity());
        }else{
            update.setQuantity(cart.getQuantity());
        }

        update.setAmount(update.getQuantity()*update.getPrice());

        userRepository.save(update);
        Optional<Cart> updateCart= userRepository.findByMedicineName(cart.getMedicineName());
        return updateCart;
    }

    @Override
    public List<Cart> getOrdesr() {
        List<Cart> listOrders= userRepository.findAll();
        return listOrders;
    }

}