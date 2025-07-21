package com.scrop.dropnow.converter;

import com.scrop.dropnow.entity.RideHistoryEntity;
import com.scrop.dropnow.model.RideConfirmDto;
import org.springframework.stereotype.Component;

@Component
public class FetchUserHistoryConvertor {
    public RideConfirmDto entityToDto(RideHistoryEntity entity){
        RideConfirmDto rideConfirmDto = new RideConfirmDto();
        rideConfirmDto.setName(entity.getName());
        rideConfirmDto.setVehicleNumber(entity.getVehicleNumber());
        rideConfirmDto.setVehicleType(entity.getVehicleType());
        rideConfirmDto.setFare(entity.getFare());
        rideConfirmDto.setDistance(entity.getDistance());
        rideConfirmDto.setTimeMultiplier(entity.getTimeMultiplier());
        rideConfirmDto.setPickupLocation(entity.getPickupLocation());
        rideConfirmDto.setDropLocation(entity.getDropLocation());
        return rideConfirmDto;
    }

}
