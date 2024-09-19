package com.example.crudDemoAdvancedMappings.services;

import com.example.crudDemoAdvancedMappings.entity.UserProfile;
import com.example.crudDemoAdvancedMappings.repo.UserProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileService {

    @Autowired
    UserProfileRepo userProfileRepo;

    public Optional<UserProfile> findUserProfileById(int id){
        return userProfileRepo.findById(id);
    }

    public List<UserProfile> getAllUserProfile(){
        return userProfileRepo.findAll();
    }

    public UserProfile saveUserProfile(UserProfile userProfile){
        return userProfileRepo.save(userProfile);
    }

    public  void deleteUserProfileById(int id){
        userProfileRepo.deleteById(id);
    }
}
