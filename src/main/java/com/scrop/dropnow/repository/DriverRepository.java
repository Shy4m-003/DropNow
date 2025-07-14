package com.scrop.dropnow.repository;

import com.scrop.dropnow.entity.DriverEntity;
import org.springframework.data.repository.CrudRepository;


import java.util.Optional;

public interface DriverRepository extends CrudRepository<DriverEntity, Long> {
    Optional<DriverEntity> findByUserNameAndPassword(String driverName, String password);
    Optional<DriverEntity> findByEmailId(String emailId);
    Optional<DriverEntity> findByUserName(String userName);
}
