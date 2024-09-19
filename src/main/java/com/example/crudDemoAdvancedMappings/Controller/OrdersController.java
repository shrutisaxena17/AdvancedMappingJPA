package com.example.crudDemoAdvancedMappings.Controller;

import com.example.crudDemoAdvancedMappings.entity.Orders;
import com.example.crudDemoAdvancedMappings.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    @GetMapping
    public List<Orders> getOrders(){
        return ordersService.getAllOrders();
    }

    @PostMapping
    public void saveOrder(@RequestBody Orders orders){
        ordersService.saveOrders(orders);
    }

    @GetMapping("/{id}")
    public Optional<Orders> findOrdersById(@PathVariable int id){
        return ordersService.getOrdersById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable int id){
        ordersService.deleteOrdersById(id);
    }
}