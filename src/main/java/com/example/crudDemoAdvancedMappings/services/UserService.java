package com.example.crudDemoAdvancedMappings.services;

import com.example.crudDemoAdvancedMappings.entity.Orders;
import com.example.crudDemoAdvancedMappings.entity.User;
import com.example.crudDemoAdvancedMappings.entity.UserProfile;
import com.example.crudDemoAdvancedMappings.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;


    public User add(User user) {
        if (user.getOrders() != null) {
            for (Orders order : user.getOrders()) {
                order.setUser(user);
            }
        }
        return userRepo.save(user);
    }


    public List<User> getAllUser(){
        return userRepo.findAll();
    }

    @Transactional
    public Optional<User> findUserById(int id){
      return  userRepo.findById(id);
    }

    public void deleteUserById(int id){
        userRepo.deleteById(id);
    }


}
