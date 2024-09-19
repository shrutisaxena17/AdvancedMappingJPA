package com.example.crudDemoAdvancedMappings.repo;

import com.example.crudDemoAdvancedMappings.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
}
