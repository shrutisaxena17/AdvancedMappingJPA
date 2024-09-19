package com.example.crudDemoAdvancedMappings.repo;

import com.example.crudDemoAdvancedMappings.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepo extends JpaRepository<Roles,Integer> {
}
