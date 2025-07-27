package com.scrop.dropnow.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCredentialsDto {
    private String userName;
    @NotEmpty(message = "Mobile Number cannot be empty")
    @Size(min = 10, max = 10,message = "Mobile should be 10 Digits Long")
    private String mobileNumber;
    private String existingPassword;
    private String password;
}
