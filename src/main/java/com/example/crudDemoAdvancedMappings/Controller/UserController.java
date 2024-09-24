package com.example.crudDemoAdvancedMappings.Controller;

import com.example.crudDemoAdvancedMappings.DTO.UserDTO;
import com.example.crudDemoAdvancedMappings.exceptionClass.UserIdNotFoundException;
import com.example.crudDemoAdvancedMappings.responseEntity.UserResponseEntity;
import com.example.crudDemoAdvancedMappings.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> getUsers(){
        return userService.getAllUser();
    }

    @PostMapping
    public void saveUser(@RequestBody UserDTO userDTO){
        userService.add(userDTO);
    }

    @GetMapping("/{id}")
    public Optional<UserDTO> findUserUsingId(@PathVariable int id){
        return userService.findUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteByUsingId(@PathVariable int id){
        userService.deleteUserById(id);
    }

}
