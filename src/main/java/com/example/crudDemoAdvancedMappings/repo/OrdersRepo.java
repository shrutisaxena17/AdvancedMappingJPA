package com.example.crudDemoAdvancedMappings.repo;

import com.example.crudDemoAdvancedMappings.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepo extends JpaRepository<Orders,Integer> {
}
