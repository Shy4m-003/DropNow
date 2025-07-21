package com.scrop.dropnow.repository;

import com.scrop.dropnow.entity.RideHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RideHistoryRepository extends JpaRepository<RideHistoryEntity,Long> {
    List<RideHistoryEntity> findAllByUserEntity_Id(Long userId);
    List<RideHistoryEntity> findAllByDriverEntity_Id(Long driverId);
}
