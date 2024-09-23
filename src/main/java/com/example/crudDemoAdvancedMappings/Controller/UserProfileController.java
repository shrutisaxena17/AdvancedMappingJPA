package com.example.crudDemoAdvancedMappings.Controller;

import com.example.crudDemoAdvancedMappings.DTO.UserProfileDTO;
import com.example.crudDemoAdvancedMappings.entity.UserProfile;
import com.example.crudDemoAdvancedMappings.services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/userProfile")
public class UserProfileController {

    @Autowired
    UserProfileService userProfileService;

    @GetMapping
    public List<UserProfileDTO> getAllDetails(){
    return userProfileService.getAllUserProfile();
    }

    @PostMapping
    public UserProfileDTO createUserProfile(@RequestBody UserProfileDTO userProfileDTO) {
      return userProfileService.saveUserProfile(userProfileDTO);
    }

    @GetMapping("/{id}")
    Optional<UserProfileDTO> findProfileById(@PathVariable int id){
        return userProfileService.findUserProfileById(id);
    }

    @DeleteMapping("/{id}")
    void deleteProfile(@PathVariable int id){
        userProfileService.deleteUserProfileById(id);
    }

}
