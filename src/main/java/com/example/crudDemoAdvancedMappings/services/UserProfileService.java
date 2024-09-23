package com.example.crudDemoAdvancedMappings.services;

import com.example.crudDemoAdvancedMappings.DTO.UserProfileDTO;
import com.example.crudDemoAdvancedMappings.entity.UserProfile;
import com.example.crudDemoAdvancedMappings.repo.UserProfileRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserProfileService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserProfileRepo userProfileRepo;

    public Optional<UserProfileDTO> findUserProfileById(int id){
        Optional<UserProfile> userProfile = userProfileRepo.findById(id);
        UserProfileDTO userProfileDTO=modelMapper.map(userProfile,UserProfileDTO.class);
        return Optional.ofNullable(userProfileDTO);
    }

    public List<UserProfileDTO> getAllUserProfile(){
       List<UserProfile> userProfileList=userProfileRepo.findAll();
       List<UserProfileDTO> userProfileDTOList=userProfileList.stream()
               .map(userProfile -> modelMapper.map(userProfile,UserProfileDTO.class))
               .collect(Collectors.toList());
       return userProfileDTOList;
    }

    public UserProfileDTO saveUserProfile(UserProfileDTO userProfileDTO){
        //convert DTO to entity
        UserProfile userProfile=modelMapper.map(userProfileDTO,UserProfile.class);

        //saving the userProfile
        UserProfile saveUserProfile=userProfileRepo.save(userProfile);

        return modelMapper.map(saveUserProfile,UserProfileDTO.class);
    }

    public  void deleteUserProfileById(int id){
        userProfileRepo.deleteById(id);
    }
}
