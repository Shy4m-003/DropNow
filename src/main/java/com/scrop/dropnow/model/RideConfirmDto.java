package com.scrop.dropnow.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RideConfirmDto {
    private String name;
    private String vehicleType;
    private String vehicleNumber;
    private String pickupLocation;
    private String dropLocation;
    private double distance;
    private double fare;
    private double timeMultiplier;
    private double userId;
    private double driverId;
    private String userName;
}
