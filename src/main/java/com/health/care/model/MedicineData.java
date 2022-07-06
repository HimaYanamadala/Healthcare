package com.health.care.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.annotations.Generated;

@Entity
@Table(name = "MEDICINE_DATA")
@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
public class MedicineData {

    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    @Id
    private int id;

    @Column(name="medicine_name")
    private String medicineName;

    @Column(name="company_name")
    private String companyName;

    @Column(name = "price")
    private int price;

    @Column(name = "quantity")
    private int quantity;

    @Column(name="uses")
    private String uses;

    @Column(name="discount")
    private String discount;

    @Column(name="expireDate")
    private Date expireDate;

    public MedicineData() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUses() {
        return uses;
    }

    public void setUses(String uses) {
        this.uses = uses;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }
}
