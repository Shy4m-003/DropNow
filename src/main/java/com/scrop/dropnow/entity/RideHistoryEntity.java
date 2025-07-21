package com.scrop.dropnow.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "RideHistory")
public class RideHistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="driver_id")
    private DriverEntity driverEntity;
    private String name;
    private String vehicleType;
    private String vehicleNumber;
    private String pickupLocation;
    private String dropLocation;
    private double distance;
    private double fare;
    private double timeMultiplier;
    private String USER_NAME;
}
