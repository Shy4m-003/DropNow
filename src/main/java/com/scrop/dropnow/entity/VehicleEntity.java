package com.scrop.dropnow.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "VehicleEntity")
public class VehicleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String vehicleType;
    private String registrationNumber;
    private String brand;
    private String color;
    private String seatingCapacity;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VehicleOwner" ,nullable = false)
    private DriverEntity driverEntity;
}
