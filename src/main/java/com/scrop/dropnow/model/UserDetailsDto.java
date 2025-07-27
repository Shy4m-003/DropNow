package com.scrop.dropnow.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetailsDto {
    private String firstName;
    private String lastName;
    private String gender;
    private String age;
    private String emailId;
    private String address;
    private String location;
    private String emergencyContact;

    private String userName;
    private String mobileNumber;
}
