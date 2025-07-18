package com.scrop.dropnow.repository;

import com.scrop.dropnow.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface VehicleRepository extends JpaRepository<VehicleEntity, Long> {
    List<VehicleEntity> findByVehicleType(String vehicleType);

}
