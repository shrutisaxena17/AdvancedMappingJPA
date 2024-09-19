package com.example.crudDemoAdvancedMappings.repo;

import com.example.crudDemoAdvancedMappings.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepo extends JpaRepository<UserProfile,Integer> {
}
