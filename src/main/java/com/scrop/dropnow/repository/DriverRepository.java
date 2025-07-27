package com.scrop.dropnow.repository;

import com.scrop.dropnow.entity.DriverEntity;
import org.springframework.data.repository.CrudRepository;


import java.util.Optional;

public interface DriverRepository extends CrudRepository<DriverEntity, Long> {
    Optional<DriverEntity> findByMobileNumberAndPassword(String mobileNumber, String password);
    Optional<DriverEntity> findByMobileNumber(String mobileNumber);
    Optional<DriverEntity> findByUserName(String userName);
}
