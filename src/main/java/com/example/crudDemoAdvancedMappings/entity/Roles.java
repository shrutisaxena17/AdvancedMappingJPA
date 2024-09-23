package com.example.crudDemoAdvancedMappings.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int roleId;

    String roleName;

    @ManyToMany(mappedBy = "roles")
    private List<User> user;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }
}
