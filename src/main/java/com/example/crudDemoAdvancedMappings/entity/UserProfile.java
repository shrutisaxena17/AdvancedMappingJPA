package com.example.crudDemoAdvancedMappings.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userProfileId;
    private String firstName;
    private String lastName;
    private String phone_number;

    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
    private User user;

    public UserProfile() {
    }

    public UserProfile(int userProfileId, String firstName, String lastName, String phone_number,User user) {
        this.userProfileId = userProfileId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone_number = phone_number;
    }

    public int getUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileId(int userProfileId) {
        this.userProfileId = userProfileId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "userProfileId=" + userProfileId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }
}
