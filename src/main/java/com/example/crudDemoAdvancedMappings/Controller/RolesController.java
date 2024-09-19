package com.example.crudDemoAdvancedMappings.Controller;
import com.example.crudDemoAdvancedMappings.entity.Roles;
import com.example.crudDemoAdvancedMappings.services.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
public class RolesController {

    @Autowired
    RolesService rolesService;

    @GetMapping
    public List<Roles> getRoles(){
        return rolesService.getAllRoles();
    }

    @PostMapping
    public void saveRoles(@RequestBody Roles roles){
        rolesService.saveRoles(roles);
    }

    @GetMapping("/{id}")
    public Optional<Roles> findRolesById(@PathVariable int id){
        return rolesService.getRolesById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteRoles(@PathVariable int id){
        rolesService.deleteRolesById(id);
    }
}
