package com.example.crudDemoAdvancedMappings.services;

import com.example.crudDemoAdvancedMappings.DTO.OrdersDTO;
import com.example.crudDemoAdvancedMappings.entity.Orders;
import com.example.crudDemoAdvancedMappings.repo.OrdersRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrdersService {


    @Autowired
    ModelMapper modelMapper;

    @Autowired
    OrdersRepo ordersRepo;

    public List<OrdersDTO> getAllOrders(){
        List<Orders> ordersList= ordersRepo.findAll();
        List<OrdersDTO> ordersDTOList=ordersList.stream()
                .map(orders -> modelMapper.map(orders, OrdersDTO.class))
                .collect(Collectors.toList());
        return ordersDTOList;
    }

    public void saveOrders(Orders orders){
        ordersRepo.save(orders);
    }

    public Optional<OrdersDTO> getOrdersById(int id){
       Optional<Orders> orders = ordersRepo.findById(id);
       OrdersDTO ordersDTO=modelMapper.map(orders,OrdersDTO.class);
       return Optional.ofNullable(ordersDTO);
    }

    public void deleteOrdersById(int id){
        ordersRepo.deleteById(id);
    }
}
