package com.example.crudDemoAdvancedMappings.Controller;

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
    public List<UserProfile> getAllDetails(){
    return userProfileService.getAllUserProfile();
    }

    @PostMapping
    public UserProfile createUserProfile(@RequestBody UserProfile userProfile) {
      return userProfileService.saveUserProfile(userProfile);
    }

    @GetMapping("/{id}")
    Optional<UserProfile> findProfileById(@PathVariable int id){
        return userProfileService.findUserProfileById(id);
    }

    @DeleteMapping("/{id}")
    void deleteProfile(@PathVariable int id){
        userProfileService.deleteUserProfileById(id);
    }

}
