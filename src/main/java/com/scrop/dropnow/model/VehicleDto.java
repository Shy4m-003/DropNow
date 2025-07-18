package com.scrop.dropnow.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class VehicleDto {
    private String Name;
    private String vehicleType;
    private String registrationNumber;
    private String seatingCapacity;
    private Long driverId;
}
