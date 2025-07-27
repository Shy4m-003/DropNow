package com.scrop.dropnow.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "USER_DETAILS")
public class UserDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String firstName;
    private String lastName;
    private String age;
    private String gender;
    private String emailId;
    private String address;
    private String location;
    private String emergencyContact;
    @OneToOne
    @JoinColumn(name = "user_id",nullable = false)
    private UserEntity user;
}
