package com.scrop.dropnow.converter;

import com.scrop.dropnow.entity.DriverEntity;
import com.scrop.dropnow.entity.RideHistoryEntity;
import com.scrop.dropnow.entity.UserEntity;
import com.scrop.dropnow.model.RideConfirmDto;
import com.scrop.dropnow.repository.DriverRepository;
import com.scrop.dropnow.repository.User_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RideConfirmConverter {
    @Autowired
    private User_Repository userRepository;
    @Autowired
    private DriverRepository driverRepository;
    public RideHistoryEntity dtoToEntity(RideConfirmDto Dto){
        RideHistoryEntity entity = new RideHistoryEntity();
        entity.setVehicleType(Dto.getVehicleType());
        entity.setVehicleNumber(Dto.getVehicleNumber());
        entity.setName(Dto.getName());
        entity.setFare(Dto.getFare());
        entity.setDistance(Dto.getDistance());
        entity.setTimeMultiplier(Dto.getTimeMultiplier());
        entity.setPickupLocation(Dto.getPickupLocation());
        entity.setDropLocation(Dto.getDropLocation());
        UserEntity user = userRepository.findById((long)Dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        DriverEntity driver = driverRepository.findById((long)Dto.getDriverId())
                .orElseThrow(() -> new RuntimeException("Driver not found"));
        user.setId((long)Dto.getUserId());
        entity.setUserEntity(user);
        entity.setUSER_NAME(user.getUserName());
        driver.setId((long)Dto.getDriverId());
        entity.setDriverEntity(driver);
        return entity;
    }
    public RideConfirmDto entityTODto(RideHistoryEntity entity){
        RideConfirmDto rideConfirmDto = new RideConfirmDto();
        rideConfirmDto.setName(entity.getName());
        rideConfirmDto.setVehicleNumber(entity.getVehicleNumber());
        rideConfirmDto.setFare(entity.getFare());
        rideConfirmDto.setDistance(entity.getDistance());
        rideConfirmDto.setTimeMultiplier(entity.getTimeMultiplier());
        rideConfirmDto.setPickupLocation(entity.getPickupLocation());
        rideConfirmDto.setDropLocation(entity.getDropLocation());
        rideConfirmDto.setUserName(entity.getUSER_NAME());
        return rideConfirmDto;
    }
}
