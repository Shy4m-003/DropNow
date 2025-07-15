package com.scrop.dropnow.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class VehicleDto {
    private String vehicleType;
    private String registrationNumber;
    private String brand;
    private String color;
    private String seatingCapacity;
    private Long driverId;
}
