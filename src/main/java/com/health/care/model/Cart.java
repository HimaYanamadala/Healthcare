package com.health.care.model;

import javax.persistence.*;

@Entity
@Table(name="cart")
@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
public class Cart {

    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    @Id
    private int id;

    @Column(name="medicineName")
    private String medicineName;

    @Column(name = "price")
    private int price;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "amount")
    private int amount;

    public Cart() {

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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
