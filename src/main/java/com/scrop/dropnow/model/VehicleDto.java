package com.scrop.dropnow.model;

import com.fasterxml.jackson.annotation.JsonInclude;
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
    private String userName;
    private String mobileNumber;
}
