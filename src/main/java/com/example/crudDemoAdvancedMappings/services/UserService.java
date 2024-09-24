package com.example.crudDemoAdvancedMappings.services;

import com.example.crudDemoAdvancedMappings.DTO.UserDTO;
import com.example.crudDemoAdvancedMappings.entity.Orders;
import com.example.crudDemoAdvancedMappings.entity.Roles;
import com.example.crudDemoAdvancedMappings.entity.User;
import com.example.crudDemoAdvancedMappings.entity.UserProfile;
import com.example.crudDemoAdvancedMappings.exceptionClass.UserIdNotFoundException;
import com.example.crudDemoAdvancedMappings.repo.RolesRepo;
import com.example.crudDemoAdvancedMappings.repo.UserRepo;
import com.example.crudDemoAdvancedMappings.responseEntity.UserResponseEntity;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RolesRepo rolesRepo;

    @Autowired
    private ModelMapper modelMapper;


    public UserDTO add(UserDTO userDTO) {

        //convert DTO to entity
        User user=modelMapper.map(userDTO, User.class);

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

        //save user entity to the repository
        User saveUser=userRepo.save(user);

        //convert entity back to DTO
        return modelMapper.map(saveUser,UserDTO.class);
    }


    public List<UserDTO> getAllUser(){
        List<User> allUser = userRepo.findAll();
        List<UserDTO> userDTO=allUser.stream()
                .map(user -> modelMapper.map(user,UserDTO.class))
                .collect(Collectors.toList());
        return userDTO;
    }

    @Transactional
    public Optional<UserDTO> findUserById(int id){
        Optional<User> user = userRepo.findById(id);
        if(user.isEmpty()){
            throw new UserIdNotFoundException("User is not found for id "+id);
        }
      UserDTO userDTO=modelMapper.map(user,UserDTO.class);
      return Optional.ofNullable(userDTO);
    }

    public void deleteUserById(int id){
        User user = userRepo.findById(id).orElse(null);
        user.getRoles().clear(); //clear all the role associated with the user
        userRepo.deleteById(id);
    }


}
