package com.example.crudDemoAdvancedMappings.services;
import com.example.crudDemoAdvancedMappings.entity.Roles;
import com.example.crudDemoAdvancedMappings.repo.RolesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolesService {
    @Autowired
    RolesRepo rolesRepo;

    public List<Roles> getAllRoles(){
        return rolesRepo.findAll();
    }

    public void saveRoles(Roles roles){
        rolesRepo.save(roles);
    }

    public Optional<Roles> getRolesById(int id){
        return rolesRepo.findById(id);
    }

    public void deleteRolesById(int id){
        rolesRepo.deleteById(id);
    }
}
