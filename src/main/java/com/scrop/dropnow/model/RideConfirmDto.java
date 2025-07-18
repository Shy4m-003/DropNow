package com.scrop.dropnow.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RideConfirmDto {
    private String name;
    private String vehicleType;
    private String vehicleNumber;
    private String pickupLocation;
    private String dropLocation;
    private double distance;
    private double fare;
    private double timeMultiplier;
}
