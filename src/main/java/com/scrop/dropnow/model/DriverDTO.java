package com.scrop.dropnow.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DriverDTO {
    @NotNull(message = "Please Enter username")
    @NotEmpty(message = "username cannot be empty")
    @Size(min = 5, max = 15,message = "username should be between 5 to 15 characters")
    private String userName;
    @NotNull(message = "Please Enter Mobile Number")
    @NotEmpty(message = "Mobile Number cannot be empty")
    @NotEmpty(message = "Mobile Number cannot be empty")
    @Pattern(regexp = "\\d{10}", message = "Mobile number must be exactly 10 digits and contain only numbers")
    private String mobileNumber;
    @NotNull(message = "Please Enter Password")
    @NotEmpty(message = "Password cannot be empty")
    @Size(min = 8,message = "Password should atleast have 8 characters")
    private String password;
    private Long id;
}
