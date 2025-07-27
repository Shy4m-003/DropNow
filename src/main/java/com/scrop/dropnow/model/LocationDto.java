package com.scrop.dropnow.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationDto {
    @NotNull(message = "Pickup location cannot be null")
    @NotBlank(message = "Pickup location cannot be blank")
    @Pattern(regexp = "^[A-Za-z0-9 ,'-]{6,50}$", message = "Pickup location should contain only valid characters and be 6–50 characters long")
    private String pickUp;
    @NotNull(message = "Drop location cannot be null")
    @NotBlank(message = "Drop location cannot be blank")
    @Pattern(regexp = "^[A-Za-z0-9 ,'-]{6,50}$", message = "Drop location should contain only valid characters and be 6–50 characters long")
    private String Drop;
}
