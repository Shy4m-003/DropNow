package com.scrop.dropnow.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class DriverDTO {
    private String userName;
    private String emailId;
    private String password;
    private String licenseNumber;
    private String vehicle;
    private Long rating;
}
