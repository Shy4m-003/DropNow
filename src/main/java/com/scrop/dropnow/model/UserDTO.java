package com.scrop.dropnow.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class UserDTO {
    private Long id;
    @NotNull(message = "Please Enter username")
    @NotEmpty(message = "username cannot be empty")
    @Size(min = 5, max = 15,message = "username should be between 5 to 15 characters")
    private String userName;
    @NotNull(message = "Please Enter Email Id")
    @NotEmpty(message = "Email Id cannot be empty")
    @Size(min = 15, max = 50,message = "Email id should be between 15 to 50 characters")
    private String emailId;
    @NotNull(message = "Please Enter Password")
    @NotEmpty(message = "Password cannot be empty")
    @Size(min = 8,message = "Password should atleast have 8 characters")
    private String password;
}
