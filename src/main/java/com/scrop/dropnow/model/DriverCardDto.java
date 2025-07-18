package com.scrop.dropnow.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DriverCardDto {
    private Long driverId;
    private String name;
    private String vehicleType;
    private String vehicleNumber;
    private String pickUp;
    private String Drop;
    private double distance;
    private double fare;
    private double timeMultiplier;
}
