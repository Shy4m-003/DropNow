package com.scrop.dropnow.repository;

import com.scrop.dropnow.entity.UserRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRequestRepository extends JpaRepository<UserRequestEntity,Long> {
      List<UserRequestEntity> findByVehicleType(String vehicleType);
}
