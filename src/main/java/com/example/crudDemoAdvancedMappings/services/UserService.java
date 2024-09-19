package com.example.crudDemoAdvancedMappings.services;

import com.example.crudDemoAdvancedMappings.entity.Orders;
import com.example.crudDemoAdvancedMappings.entity.Roles;
import com.example.crudDemoAdvancedMappings.entity.User;
import com.example.crudDemoAdvancedMappings.entity.UserProfile;
import com.example.crudDemoAdvancedMappings.repo.RolesRepo;
import com.example.crudDemoAdvancedMappings.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RolesRepo rolesRepo;

    public User add(User user) {
        if (user.getOrders() != null) {
            for (Orders order : user.getOrders()) {
                order.setUser(user);
            }
        }
        if (user.getRoles() != null) {
            List<Roles> existingRoles = new ArrayList<>();
            for (Roles role : user.getRoles()) {
                // Check if the role already exists in the database
                Roles existingRole = rolesRepo.findById(role.getRoleId()).orElse(null);
                if (existingRole != null) {
                    // Add the existing role to the list
                    existingRoles.add(existingRole);
                } else {
                    // Optionally, handle the case where the role doesn't exist
                    // You could throw an exception or handle it accordingly
                    throw new IllegalArgumentException("Role not found for ID: " + role.getRoleId());
                }
            }
            // Associate the found existing roles with the user
            user.setRoles(existingRoles);
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
