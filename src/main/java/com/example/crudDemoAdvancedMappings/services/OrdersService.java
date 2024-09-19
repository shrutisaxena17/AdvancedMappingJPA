package com.example.crudDemoAdvancedMappings.services;

import com.example.crudDemoAdvancedMappings.entity.Orders;
import com.example.crudDemoAdvancedMappings.repo.OrdersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {

    @Autowired
    OrdersRepo ordersRepo;

    public List<Orders> getAllOrders(){
        return ordersRepo.findAll();
    }

    public void saveOrders(Orders orders){
        ordersRepo.save(orders);
    }

    public Optional<Orders> getOrdersById(int id){
        return ordersRepo.findById(id);
    }

    public void deleteOrdersById(int id){
        ordersRepo.deleteById(id);
    }
}
