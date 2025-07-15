package com.scrop.dropnow.repository;

import com.scrop.dropnow.entity.UserEntity;
import com.scrop.dropnow.entity.VehicleEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VehicleRepository extends CrudRepository<VehicleEntity, Long> {
    Optional<VehicleEntity> findAllDriverEntityById(long driverId);
}
