package com.scrop.dropnow.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "ride history")
public class RideHistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
    @ManyToOne()
    @JoinColumn(name ="driver-id")
    private DriverEntity driverEntity;
    private String name;
    private String vehicleType;
    private String vehicleNumber;
    private String pickupLocation;
    private String dropLocation;
    private double distance;
    private double fare;
    private double timeMultiplier;

}
