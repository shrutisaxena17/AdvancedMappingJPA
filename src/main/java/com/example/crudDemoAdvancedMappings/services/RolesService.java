package com.example.crudDemoAdvancedMappings.services;
import com.example.crudDemoAdvancedMappings.DTO.RolesDTO;
import com.example.crudDemoAdvancedMappings.entity.Roles;
import com.example.crudDemoAdvancedMappings.repo.RolesRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RolesService {
    @Autowired
    RolesRepo rolesRepo;

    @Autowired
    ModelMapper modelMapper;

    public List<RolesDTO> getAllRoles(){
       List<Roles> rolesList=rolesRepo.findAll();
       List<RolesDTO> rolesDTOList=rolesList.stream()
               .map(roles -> modelMapper.map(roles,RolesDTO.class))
               .collect(Collectors.toList());
       return rolesDTOList;
    }

    public void saveRoles(Roles roles){
        rolesRepo.save(roles);
    }

    public Optional<RolesDTO> getRolesById(int id){
       Optional<Roles> roles=rolesRepo.findById(id);
       RolesDTO rolesDTO=modelMapper.map(roles,RolesDTO.class);
       return Optional.ofNullable(rolesDTO);
    }

    public void deleteRolesById(int id){
        rolesRepo.deleteById(id);
    }
}
