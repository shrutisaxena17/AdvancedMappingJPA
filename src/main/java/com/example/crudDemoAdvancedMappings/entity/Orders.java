package com.example.crudDemoAdvancedMappings.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    private String product;
    private double price;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Orders() {
    }

    public Orders(int orderId, String product, double price) {
        this.orderId = orderId;
        this.product = product;
        this.price = price;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", product='" + product + '\'' +
                ", price=" + price +
                '}';
    }
}
