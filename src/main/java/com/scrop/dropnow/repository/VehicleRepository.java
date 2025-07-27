package com.scrop.dropnow.repository;

import com.scrop.dropnow.entity.DriverEntity;
import com.scrop.dropnow.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface VehicleRepository extends JpaRepository<VehicleEntity, Long> {
    List<VehicleEntity> findByVehicleType(String vehicleType);
    Optional<VehicleEntity> findByDriverEntity(DriverEntity driverEntity);
    Optional<VehicleEntity> findBydriverEntity_Id(Long driverId);
}
