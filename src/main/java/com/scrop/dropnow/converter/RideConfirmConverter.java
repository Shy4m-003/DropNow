package com.scrop.dropnow.converter;

import com.scrop.dropnow.entity.DriverEntity;
import com.scrop.dropnow.entity.RideHistoryEntity;
import com.scrop.dropnow.entity.UserEntity;
import com.scrop.dropnow.model.RideConfirmDto;
import org.springframework.stereotype.Component;

@Component
public class RideConfirmConverter {
    private DriverEntity driverEntity;
    private UserEntity userEntity;
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
        entity.setDriverEntity(driverEntity);
        entity.setUserEntity(userEntity);
        return entity;
    }
}
